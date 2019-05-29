package org.hdyanfa.demo.service.impl;

import org.hdyanfa.demo.dao.ChatGroupToUserMapper;
import org.hdyanfa.demo.domain.ChatGroupToUser;
import org.hdyanfa.demo.domain.ChatGroupToUserExample;
import org.hdyanfa.demo.service.IChatGroupToUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiaochai
 * @create: 2019-05-10
 **/
@Service
public class ChatGroupToUserServiceImpl implements IChatGroupToUserService {

    @Resource
    private ChatGroupToUserMapper groupToUserMapper;

    @Override
    public List<Integer> findUidsByGid(Integer cGroupId) {
        ChatGroupToUserExample example = new ChatGroupToUserExample();
        example.or().andCGroupIdEqualTo(cGroupId).andLogicalDeleted(false);
        List<ChatGroupToUser> groupToUserList = groupToUserMapper.selectByExampleSelective(example);

        List<Integer> ids = new ArrayList<>();
        if (groupToUserList != null && groupToUserList.size() > 0){
            for (ChatGroupToUser groupToUser : groupToUserList){
                ids.add(groupToUser.getUserId());
            }
        }
        return ids;
    }


}
