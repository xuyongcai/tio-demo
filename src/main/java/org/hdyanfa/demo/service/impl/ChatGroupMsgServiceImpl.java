package org.hdyanfa.demo.service.impl;

import org.apache.commons.codec.binary.Base64;
import org.hdyanfa.demo.common.ChatMsgCode;
import org.hdyanfa.demo.dto.ChatGroupMsg;
import org.hdyanfa.demo.dto.WsMessage;
import org.hdyanfa.demo.service.IChatGroupMsgService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiaochai
 * @create: 2019-05-06
 **/
@Service
public class ChatGroupMsgServiceImpl implements IChatGroupMsgService {

    @Resource
    MongoTemplate mongoTemplate;

    /**
     * 内部类
     */
    class SaveMessageThread implements Runnable {

        private ChatGroupMsg chatGroupMsg;

        public SaveMessageThread(ChatGroupMsg chatGroupMsg) {
            this.chatGroupMsg = chatGroupMsg;
        }

        @Override
        public void run() {
            //TODO 存储聊天信息,暂时用mysql。 （需考虑频繁插入问题，后期需用hbase存储）
            mongoTemplate.save(chatGroupMsg);

        }
    }

    @Override
    public void add(ChatGroupMsg chatGroupMsg) {
        new ChatGroupMsgServiceImpl.SaveMessageThread(chatGroupMsg).run();

    }

    @Override
    public List<WsMessage> listByGid(Integer recId, Integer cGroupId, Integer page, Integer limit, String sort, String order) {

        Query query = new Query();
        query.addCriteria(Criteria.where("cGroupId").is(cGroupId).and("rec.recId")
                .is(recId).and("rec.recDeleted").is(false));

        List<ChatGroupMsg> groupMsgList = mongoTemplate.find(query, ChatGroupMsg.class);
        if (groupMsgList == null || groupMsgList.size() <= 0){
            return null;
        }

        List<WsMessage> list = new ArrayList<>();
        for (ChatGroupMsg groupMsg : groupMsgList){
            WsMessage wsMessage = new WsMessage();
            wsMessage.setId(groupMsg.getId());
            wsMessage.setFromId(groupMsg.getSendId());
            wsMessage.setToId(groupMsg.getCGroupId());
            wsMessage.setContent(Base64.encodeBase64String(groupMsg.getContent()));
            wsMessage.setMsgType(groupMsg.getMsgType());
            wsMessage.setTimestamp(groupMsg.getAddTime());
            wsMessage.setSendType(ChatMsgCode.SendType.GROUP.getCode());

            list.add(wsMessage);
        }

        //TODO 获取用户相关信息

        return list;
    }

}
