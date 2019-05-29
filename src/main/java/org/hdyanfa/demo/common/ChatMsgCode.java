package org.hdyanfa.demo.common;

/**
 * @author: xiaochai
 * @create: 2019-04-10
 **/
public class ChatMsgCode {

    public enum SendType{
        /**
         * 单聊
         */
        FRIEND(0),
        /**
         * 群聊
         */
        GROUP(1),

        /**
         * 讨论组
         */
        DISCUSS(2)
        ;

        private Integer code;

        public Integer getCode(){
            return this.code;
        }

        SendType(Integer code) {
            this.code = code;
        }
    }


    public enum MsgType{
        /**
         * 文本
         */
        TEXT(0),
        /**
         * 图片
         */
        PICTURE(1),

        /**
         * 文件
         */
        FILE(2),

        /**
         * 名片
         */
        USER_CARD(3)
        ;

        private Integer code;

        public Integer getCode(){
            return this.code;
        }

        MsgType(Integer code) {
            this.code = code;
        }
    }

    public enum SendStatus{
        /**
         * 心跳
         */
        MSG_PING(0),
        /**
         * 链接就绪
         */
        MSG_READY(1),

        /**
         * 消息
         */
        MSG_MESSAGE(2),
        ;

        private Integer code;

        public Integer getCode(){
            return this.code;
        }

        SendStatus(Integer code) {
            this.code = code;
        }
    }

}
