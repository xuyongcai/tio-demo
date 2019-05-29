package org.hdyanfa.demo.service;


import org.hdyanfa.demo.dto.ChatGroupMsg;
import org.hdyanfa.demo.dto.WsMessage;

import java.util.List;

/**
 * @author: xiaochai
 * @create: 2019-05-06
 **/
public interface IChatGroupMsgService {

    /**
     * 保存消息
     * @param chatGroupMsg 消息
     */
    void add(ChatGroupMsg chatGroupMsg);

    List<WsMessage> listByGid(Integer recId, Integer cGroupId, Integer page, Integer limit, String sort, String order);

}
