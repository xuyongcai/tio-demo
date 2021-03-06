package org.hdyanfa.demo.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class ChatMsg {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table chat_msg
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static final Boolean NOT_DELETED = false;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table chat_msg
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static final Boolean IS_DELETED = true;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat_msg.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat_msg.send_id
     *
     * @mbg.generated
     */
    private Integer sendId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat_msg.rec_id
     *
     * @mbg.generated
     */
    private Integer recId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat_msg.msg_type
     *
     * @mbg.generated
     */
    private Integer msgType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat_msg.read_status
     *
     * @mbg.generated
     */
    private Boolean readStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat_msg.send_deleted
     *
     * @mbg.generated
     */
    private Boolean sendDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat_msg.rec_deleted
     *
     * @mbg.generated
     */
    private Boolean recDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat_msg.add_time
     *
     * @mbg.generated
     */
    private LocalDateTime addTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat_msg.update_time
     *
     * @mbg.generated
     */
    private LocalDateTime updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat_msg.deleted
     *
     * @mbg.generated
     */
    private Boolean deleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column chat_msg.content
     *
     * @mbg.generated
     */
    private byte[] content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat_msg.id
     *
     * @return the value of chat_msg.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat_msg.id
     *
     * @param id the value for chat_msg.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat_msg.send_id
     *
     * @return the value of chat_msg.send_id
     *
     * @mbg.generated
     */
    public Integer getSendId() {
        return sendId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat_msg.send_id
     *
     * @param sendId the value for chat_msg.send_id
     *
     * @mbg.generated
     */
    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat_msg.rec_id
     *
     * @return the value of chat_msg.rec_id
     *
     * @mbg.generated
     */
    public Integer getRecId() {
        return recId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat_msg.rec_id
     *
     * @param recId the value for chat_msg.rec_id
     *
     * @mbg.generated
     */
    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat_msg.msg_type
     *
     * @return the value of chat_msg.msg_type
     *
     * @mbg.generated
     */
    public Integer getMsgType() {
        return msgType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat_msg.msg_type
     *
     * @param msgType the value for chat_msg.msg_type
     *
     * @mbg.generated
     */
    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat_msg.read_status
     *
     * @return the value of chat_msg.read_status
     *
     * @mbg.generated
     */
    public Boolean getReadStatus() {
        return readStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat_msg.read_status
     *
     * @param readStatus the value for chat_msg.read_status
     *
     * @mbg.generated
     */
    public void setReadStatus(Boolean readStatus) {
        this.readStatus = readStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat_msg.send_deleted
     *
     * @return the value of chat_msg.send_deleted
     *
     * @mbg.generated
     */
    public Boolean getSendDeleted() {
        return sendDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat_msg.send_deleted
     *
     * @param sendDeleted the value for chat_msg.send_deleted
     *
     * @mbg.generated
     */
    public void setSendDeleted(Boolean sendDeleted) {
        this.sendDeleted = sendDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat_msg.rec_deleted
     *
     * @return the value of chat_msg.rec_deleted
     *
     * @mbg.generated
     */
    public Boolean getRecDeleted() {
        return recDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat_msg.rec_deleted
     *
     * @param recDeleted the value for chat_msg.rec_deleted
     *
     * @mbg.generated
     */
    public void setRecDeleted(Boolean recDeleted) {
        this.recDeleted = recDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat_msg.add_time
     *
     * @return the value of chat_msg.add_time
     *
     * @mbg.generated
     */
    public LocalDateTime getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat_msg.add_time
     *
     * @param addTime the value for chat_msg.add_time
     *
     * @mbg.generated
     */
    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat_msg.update_time
     *
     * @return the value of chat_msg.update_time
     *
     * @mbg.generated
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat_msg.update_time
     *
     * @param updateTime the value for chat_msg.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat_msg.deleted
     *
     * @return the value of chat_msg.deleted
     *
     * @mbg.generated
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat_msg.deleted
     *
     * @param deleted the value for chat_msg.deleted
     *
     * @mbg.generated
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column chat_msg.content
     *
     * @return the value of chat_msg.content
     *
     * @mbg.generated
     */
    public byte[] getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column chat_msg.content
     *
     * @param content the value for chat_msg.content
     *
     * @mbg.generated
     */
    public void setContent(byte[] content) {
        this.content = content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_msg
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sendId=").append(sendId);
        sb.append(", recId=").append(recId);
        sb.append(", msgType=").append(msgType);
        sb.append(", readStatus=").append(readStatus);
        sb.append(", sendDeleted=").append(sendDeleted);
        sb.append(", recDeleted=").append(recDeleted);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_msg
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ChatMsg other = (ChatMsg) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSendId() == null ? other.getSendId() == null : this.getSendId().equals(other.getSendId()))
            && (this.getRecId() == null ? other.getRecId() == null : this.getRecId().equals(other.getRecId()))
            && (this.getMsgType() == null ? other.getMsgType() == null : this.getMsgType().equals(other.getMsgType()))
            && (this.getReadStatus() == null ? other.getReadStatus() == null : this.getReadStatus().equals(other.getReadStatus()))
            && (this.getSendDeleted() == null ? other.getSendDeleted() == null : this.getSendDeleted().equals(other.getSendDeleted()))
            && (this.getRecDeleted() == null ? other.getRecDeleted() == null : this.getRecDeleted().equals(other.getRecDeleted()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
            && (Arrays.equals(this.getContent(), other.getContent()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_msg
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSendId() == null) ? 0 : getSendId().hashCode());
        result = prime * result + ((getRecId() == null) ? 0 : getRecId().hashCode());
        result = prime * result + ((getMsgType() == null) ? 0 : getMsgType().hashCode());
        result = prime * result + ((getReadStatus() == null) ? 0 : getReadStatus().hashCode());
        result = prime * result + ((getSendDeleted() == null) ? 0 : getSendDeleted().hashCode());
        result = prime * result + ((getRecDeleted() == null) ? 0 : getRecDeleted().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        result = prime * result + (Arrays.hashCode(getContent()));
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chat_msg
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public void andLogicalDeleted(boolean deleted) {
        setDeleted(deleted ? IS_DELETED : NOT_DELETED);
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table chat_msg
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        id("id", "id", "INTEGER", false),
        sendId("send_id", "sendId", "INTEGER", false),
        recId("rec_id", "recId", "INTEGER", false),
        msgType("msg_type", "msgType", "INTEGER", false),
        readStatus("read_status", "readStatus", "BIT", false),
        sendDeleted("send_deleted", "sendDeleted", "BIT", false),
        recDeleted("rec_deleted", "recDeleted", "BIT", false),
        addTime("add_time", "addTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        deleted("deleted", "deleted", "BIT", false),
        content("content", "content", "LONGVARBINARY", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table chat_msg
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table chat_msg
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table chat_msg
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table chat_msg
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table chat_msg
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table chat_msg
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table chat_msg
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table chat_msg
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table chat_msg
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table chat_msg
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table chat_msg
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table chat_msg
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table chat_msg
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table chat_msg
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table chat_msg
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }
    }
}