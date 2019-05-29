package org.hdyanfa.demo.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: xiaochai
 * @create: 2019-05-21
 **/
@Data
public class ChatGroupMsg {
    private Integer id;

    private Integer cGroupId;

    private Integer sendId;

    private byte[] content;

    private Integer msgType;

    private Boolean sendDeleted;

    private LocalDateTime addTime;

    private LocalDateTime updateTime;

    private Boolean deleted;

    private List<ChatGroupMsgRec> rec;
}
