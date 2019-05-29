package org.hdyanfa.demo.service;

import java.util.List;

/**
 * @author: xiaochai
 * @create: 2019-05-10
 **/
public interface IChatGroupToUserService {

    List<Integer> findUidsByGid(Integer cGroupId);

}
