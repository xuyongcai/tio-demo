package org.hdyanfa.demo.service.impl;

import com.mongodb.client.result.UpdateResult;
import org.hdyanfa.demo.dto.ChatMsg;
import org.hdyanfa.demo.service.IChatMsgService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: xiaochai
 * @create: 2019-04-29
 **/
@Service
public class ChatMsgServiceImpl implements IChatMsgService {

    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 内部类
     */
    class SaveMessageThread implements Runnable {

        private ChatMsg chatMsg;

        public SaveMessageThread(ChatMsg chatMsg) {
            this.chatMsg = chatMsg;
        }

        @Override
        public void run() {
            // 存储聊天信息。
            mongoTemplate.save(chatMsg);
        }
    }


    @Override
    public void add(ChatMsg chatMsg) {
        new ChatMsgServiceImpl.SaveMessageThread(chatMsg).run();
    }


    @Override
    public List<ChatMsg> getUnReadMsg(Integer recId) {

        Query query = Query.query(Criteria.where("recId").is(recId).and("readStatus").is(false).and("deleted").is(false));

        List<ChatMsg> chatMsgList = mongoTemplate.find(query, ChatMsg.class);

        //更新数据库消息已读状态为 "已读"
        UpdateResult result = mongoTemplate.updateMulti(query, new Update().set("readStatus", true), ChatMsg.class);

        //返回的 "未读消息" 的已读状态仍是 "未读"
        return chatMsgList;
    }

}
