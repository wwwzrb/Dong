package org.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by wz on 2016/6/16.
 */
public class publishViewModel {
    private int publishId;
    private int userId;
    private String pubContent;
    private Timestamp pubTime;
    private String userName;
    private List<replyViewModel> reply;

    public int getPublishId() {
        return publishId;
    }

    public void setPublishId(int publishId) {
        this.publishId = publishId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPubContent() {
        return pubContent;
    }

    public void setPubContent(String pubContent) {
        this.pubContent = pubContent;
    }

    public Timestamp getPubTime() {
        return pubTime;
    }

    public void setPubTime(Timestamp pubTime) {
        this.pubTime = pubTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<replyViewModel> getReply() {
        return reply;
    }

    public void setReply(List<replyViewModel> reply) {
        this.reply = reply;
    }
}
