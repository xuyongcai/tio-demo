package org.hdyanfa.demo.service.impl;

import org.hdyanfa.demo.dao.my.MyChatGroupMapper;
import org.hdyanfa.demo.domain.ChatGroup;
import org.hdyanfa.demo.service.IChatGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: xiaochai
 * @create: 2019-04-10
 **/
@Service
public class ChatGroupServiceImpl implements IChatGroupService {

    @Resource
    private MyChatGroupMapper myChatGroupMapper;


    @Override
    public List<ChatGroup> queryByUserId(Integer uid) {
        return myChatGroupMapper.queryByUserId(uid);
    }


}
