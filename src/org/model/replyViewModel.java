package org.model;

import java.sql.Timestamp;

/**
 * Created by wz on 2016/6/16.
 */
public class replyViewModel {
    private int userId;
    private String repContents;
    private Timestamp repTime;
    private String userName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRepContents() {
        return repContents;
    }

    public void setRepContents(String repContents) {
        this.repContents = repContents;
    }

    public Timestamp getRepTime() {
        return repTime;
    }

    public void setRepTime(Timestamp repTime) {
        this.repTime = repTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
