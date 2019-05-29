package org.hdyanfa.demo.dto;

import lombok.Data;

/**
 * websocket 通讯的json 封装
 *
 * @author: xiaochai
 * @create: 2019-04-10
 **/
@Data
public class WsSendInfo {

    /**
     * 发送信息状态的代码，具体见 MessageCode.SendStatus 类
     */
    private Integer code;

    /**
     * 信息
     */
    private WsMessage wsMessage;
}
