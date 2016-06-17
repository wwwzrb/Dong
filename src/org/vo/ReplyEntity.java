package org.vo;

import java.sql.Timestamp;

/**
 * Created by wz on 2016/6/14.
 */
public class ReplyEntity {
    private int id;
    private String repContents;
    private Timestamp repTime;
    private UserEntity user;
    private PublishEntity publish;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public PublishEntity getPublish() {
        return publish;
    }

    public void setPublish(PublishEntity publishEntity) {
        this.publish = publishEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReplyEntity that = (ReplyEntity) o;

        if (id != that.id) return false;
        if (repContents != null ? !repContents.equals(that.repContents) : that.repContents != null) return false;
        if (repTime != null ? !repTime.equals(that.repTime) : that.repTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (repContents != null ? repContents.hashCode() : 0);
        result = 31 * result + (repTime != null ? repTime.hashCode() : 0);
        return result;
    }
}
