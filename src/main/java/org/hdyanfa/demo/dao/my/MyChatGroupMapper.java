package org.hdyanfa.demo.dao.my;

import org.apache.ibatis.annotations.Param;
import org.hdyanfa.demo.domain.ChatGroup;

import java.util.List;

/**
 * @author: xiaochai
 * @create: 2019-05-07
 **/
public interface MyChatGroupMapper {

    List<ChatGroup> queryByUserId(@Param("userId") Integer userId);

    ChatGroup findByCG2Uid(Integer cg2uid);

    List<ChatGroup> findByUidAndType(@Param("userId") Integer userId, @Param("type") Integer type);
}
