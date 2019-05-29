package org.hdyanfa.demo.service.impl;

import org.hdyanfa.demo.dao.UserMapper;
import org.hdyanfa.demo.domain.User;
import org.hdyanfa.demo.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: xiaochai
 * @create: 2019-05-13
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User find(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
