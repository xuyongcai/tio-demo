package org.hdyanfa.demo.tio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.log.LogFactory;
import org.apache.commons.codec.binary.Base64;
import org.hdyanfa.demo.common.ChatMsgCode;
import org.hdyanfa.demo.domain.ChatGroup;
import org.hdyanfa.demo.dto.ChatMsg;
import org.hdyanfa.demo.domain.User;
import org.hdyanfa.demo.dto.ChatGroupMsg;
import org.hdyanfa.demo.dto.ChatGroupMsgRec;
import org.hdyanfa.demo.dto.WsMessage;
import org.hdyanfa.demo.dto.WsSendInfo;
import org.hdyanfa.demo.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;
import org.tio.http.common.HttpRequest;
import org.tio.http.common.HttpResponse;
import org.tio.utils.lock.SetWithLock;
import org.tio.websocket.common.WsRequest;
import org.tio.websocket.common.WsResponse;
import org.tio.websocket.server.handler.IWsMsgHandler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * websocket 处理函数
 *
 * @author: xiaochai
 * @create: 2019-04-10
 **/
@Component
public class TioWsMsgHandler implements IWsMsgHandler {

    private static Logger log = LoggerFactory.getLogger(TioWsMsgHandler.class);


    @Autowired
    private IUserService userService;

    @Autowired
    private IChatGroupService chatGroupService;
    @Autowired
    private IChatGroupToUserService groupToUserService;

    @Autowired
    private IChatMsgService chatMsgService;

    @Autowired
    private IChatGroupMsgService chatGroupMsgService;

    /**
     * 握手时走这个方法，业务可以在这里获取cookie，request参数等
     *
     * @param request
     * @param response
     * @param channelContext
     * @return HttpResponse
     * @throws Exception
     */
    @Override
    public HttpResponse handshake(HttpRequest request, HttpResponse response, ChannelContext channelContext) throws Exception {

        //TODO 根据相关安全框架，获取已登陆的userId，这里先写死
        Integer userId = Integer.valueOf(request.getParam("userId"));
//        Integer userId = 1;

        //绑定用户
        Tio.bindUser(channelContext, String.valueOf(userId));

        //绑定群组
        List<ChatGroup> groupList = chatGroupService.queryByUserId(userId);

        if (groupList != null && groupList.size() > 0){
            for (ChatGroup chatGroup : groupList) {
                Tio.bindGroup(channelContext, String.valueOf(chatGroup.getId()));
            }
        }

        return response;
    }

    @Override
    public void onAfterHandshaked(HttpRequest httpRequest, HttpResponse httpResponse, ChannelContext channelContext) throws Exception {

    }

    /**
     * 字节消息（binaryType = arraybuffer）过来后，会走这个方法
     *
     * @param wsRequest
     * @param bytes
     * @param channelContext
     * @return
     * @throws Exception
     */
    @Override
    public Object onBytes(WsRequest wsRequest, byte[] bytes, ChannelContext channelContext) throws Exception {
        return null;
    }

    /**
     * 当客户端发close flag时，会走这个方法
     *
     * @param wsRequest
     * @param bytes
     * @param channelContext
     * @return
     * @throws Exception
     */
    @Override
    public Object onClose(WsRequest wsRequest, byte[] bytes, ChannelContext channelContext) throws Exception {
        Tio.remove(channelContext, "receive close flag");
        return null;
    }

    /**
     * 字符消息（binaryType = blob）过来后，会走这个方法
     *
     * @param wsRequest
     * @param text
     * @param channelContext
     * @return
     * @throws Exception
     */
    @Override
    public Object onText(WsRequest wsRequest, String text, ChannelContext channelContext) throws Exception {
        log.info("ON_Text...");

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            WsSendInfo wsSendInfo = objectMapper.readValue(text, WsSendInfo.class);

            // 心跳检测包
            if (ChatMsgCode.SendStatus.MSG_PING.getCode().equals(wsSendInfo.getCode())) {
                log.info("MSG_PING...");

                WsResponse wsResponse = WsResponse.fromText(text, TioServerConfig.CHARSET);
                Tio.send(channelContext, wsResponse);
            }
            // 真正的消息
            else if (ChatMsgCode.SendStatus.MSG_MESSAGE.getCode().equals(wsSendInfo.getCode())) {
                log.info("MSG_MESSAGE...");

                WsMessage wsMessage = wsSendInfo.getWsMessage();
                wsMessage.setSend(false);
                WsResponse wsResponse = WsResponse.fromText(objectMapper.writeValueAsString(wsSendInfo), TioServerConfig.CHARSET);

                // 单聊
                if (ChatMsgCode.SendType.FRIEND.getCode().equals(wsMessage.getSendType())) {
                    log.info("FRIEND...");

                    SetWithLock<ChannelContext> channelContextSetWithLock = Tio.getChannelContextsByUserid(channelContext.groupContext, String.valueOf(wsMessage.getToId()));

                    // 用户没有登录，存储到离线文件
                    if (channelContextSetWithLock == null || channelContextSetWithLock.size() == 0) {
                        log.info("存到离线数据...");

                        saveFriendMessage(wsMessage, false);

                        log.info("保存数据成功...");
                    } else {
                        log.info("用户已登录，存到数据...");
                        Tio.sendToUser(channelContext.groupContext, String.valueOf(wsMessage.getToId()), wsResponse);
                        // 入库操作
                        saveFriendMessage(wsMessage, true);
                    }

                } else {    // 群聊

                    Tio.sendToGroup(channelContext.groupContext, String.valueOf(wsMessage.getToId()), wsResponse);
                    // 入库操作
                    saveGroupMessage(wsMessage, true);
                }
            }
            // 准备就绪，需要发送离线消息
            else if (ChatMsgCode.SendStatus.MSG_READY.getCode().equals(wsSendInfo.getCode())) {
                log.info("MSG_READY...");

                // 未读消息
                sendOffLineMessage(channelContext, objectMapper);
            }
        } catch (IOException e) {
            e.printStackTrace();

            log.info("IOException...");

        }
        //返回值是要发送给客户端的内容，一般都是返回null
        return null;
    }


    /**
     * 发送未读消息
     *
     * @param channelContext channelContext
     * @param objectMapper   objectMapper
     * @throws IOException 抛出异常
     */
    private void sendOffLineMessage(ChannelContext channelContext, ObjectMapper objectMapper) throws IOException {

        // 根据接收人的id，获取未读消息，且更新消息状态
        List<ChatMsg> chatMsgList = chatMsgService.getUnReadMsg(Integer.valueOf(channelContext.userid));

        for (ChatMsg msg : chatMsgList) {

            WsMessage wsMessage = new WsMessage();
            wsMessage.setId(msg.getId());
            wsMessage.setSend(false);
            wsMessage.setSendType(ChatMsgCode.SendType.FRIEND.getCode());

            User user = userService.find(msg.getSendId());
            wsMessage.setAvatar(user.getUserface());
            wsMessage.setUsername(user.getUsername());

            wsMessage.setMsgType(msg.getMsgType());
            wsMessage.setToId(msg.getRecId());
            wsMessage.setFromId(msg.getSendId());
            wsMessage.setContent(Base64.encodeBase64String(msg.getContent()));
            wsMessage.setTimestamp(msg.getAddTime());

            WsSendInfo wsSendInfo = new WsSendInfo();
            wsSendInfo.setCode(ChatMsgCode.SendStatus.MSG_MESSAGE.getCode());
            wsSendInfo.setWsMessage(wsMessage);

            WsResponse wsResponse = WsResponse.fromText(objectMapper.writeValueAsString(wsSendInfo), TioServerConfig.CHARSET);
            Tio.sendToUser(channelContext.groupContext, String.valueOf(wsMessage.getToId()), wsResponse);
        }
    }

    /**
     * 保存单聊信息
     *
     * @param wsMessage 信息
     * @param readStatus 是否已读
     */
    private void saveFriendMessage(WsMessage wsMessage, Boolean readStatus) {

        ChatMsg chatMsg = new ChatMsg();

        chatMsg.setId(1);
        chatMsg.setRecId(wsMessage.getToId());
        chatMsg.setSendId(wsMessage.getFromId());
        chatMsg.setContent(Base64.decodeBase64(wsMessage.getContent()));
        chatMsg.setReadStatus(readStatus);
        chatMsg.setMsgType(wsMessage.getMsgType());
        chatMsg.setSendDeleted(false);
        chatMsg.setRecDeleted(false);
        chatMsg.setAddTime(LocalDateTime.now());
        chatMsg.setUpdateTime(LocalDateTime.now());
        chatMsg.setDeleted(false);

        chatMsgService.add(chatMsg);

    }

    /**
     * 保存群信息
     *
     * @param wsMessage 信息
     * @param readStatus 是否已读
     */
    private void saveGroupMessage(WsMessage wsMessage, Boolean readStatus) {

        Integer userId = 1;

        // 1.群消息主体数据
        ChatGroupMsg chatGroupMsg = new ChatGroupMsg();

        chatGroupMsg.setId(1);
        chatGroupMsg.setCGroupId(wsMessage.getToId());
        chatGroupMsg.setSendId(wsMessage.getFromId());
        chatGroupMsg.setContent(Base64.decodeBase64(wsMessage.getContent()));
        chatGroupMsg.setMsgType(wsMessage.getMsgType());
        chatGroupMsg.setSendDeleted(false);
        chatGroupMsg.setAddTime(LocalDateTime.now());
        chatGroupMsg.setUpdateTime(LocalDateTime.now());

        // 2.群消息关联用户数据
        List<Integer> uidList = groupToUserService.findUidsByGid(wsMessage.getToId());
        List<ChatGroupMsgRec> recList = new ArrayList<>();

        for (Integer uid : uidList){
            // 接收人排除自己
            if (uid.equals(wsMessage.getFromId())){
                continue;
            }

            ChatGroupMsgRec rec = new ChatGroupMsgRec();
            rec.setRecId(uid);
            rec.setReadStatus(readStatus);
            rec.setRecDeleted(false);

            recList.add(rec);
        }
        chatGroupMsg.setRec(recList);

        chatGroupMsgService.add(chatGroupMsg);

        //TODO 每个人的readStatus该如何确定


    }
}
