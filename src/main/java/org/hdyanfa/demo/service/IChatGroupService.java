package org.hdyanfa.demo.service;

import org.hdyanfa.demo.domain.ChatGroup;

import java.util.List;

/**
 * @author: xiaochai
 * @create: 2019-04-10
 **/
public interface IChatGroupService {


    List<ChatGroup> queryByUserId(Integer uid);



}
