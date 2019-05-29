package org.hdyanfa.demo.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * websocket 通讯的json
 *
 * @author: xiaochai
 * @create: 2019-04-10
 **/
@Data
public class WsMessage {

    /**
     * 消息来源用户名
     */
    private String username;

    /**
     * 发送者头像
     */
    private String avatar;

    /**
     * 消息的ID
     */
    private Integer id;

    /**
     * 消息的发送者id
     */
    private Integer fromId;

    /**
     * 消息的来源ID（如果是私聊，则是用户id；如果是群聊，则是群组id；如果是讨论组，则是讨论组id）
     */
    private Integer toId;

    /**
     * 消息内容
     */
    private byte[] content;

    /**
     * 发送消息类型, 单聊 or 群聊 等
     */
    private Integer sendType;

    /**
     * 消息类型, 文本 or 图片 等
     */
    private Integer msgType;

    /**
     * 服务端时间戳毫秒数
     */
    private LocalDateTime timestamp;

    /**
     * 是否被人发送
     */
    private boolean isSend;


}
