package org.hdyanfa.demo.service;

import org.hdyanfa.demo.dto.ChatMsg;

import java.util.List;

/**
 * @author: xiaochai
 * @create: 2019-04-29
 **/
public interface IChatMsgService {

    /**
     * 保存消息
     * @param chatMsg 消息
     */
    void add(ChatMsg chatMsg);

    /**
     * 根据接收人的id，获取未读消息。
     * 同时更新数据库消息已读状态为 "已读"
     * @param recId
     * @return  返回的 "未读消息" 的已读状态仍是 "未读"
     */
    List<ChatMsg> getUnReadMsg(Integer recId);
}
