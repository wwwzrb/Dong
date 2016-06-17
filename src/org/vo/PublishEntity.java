package org.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wz on 2016/6/14.
 */
public class PublishEntity {
    private int publishId;
    private String pubContent;
    private Timestamp pubTime;
    private UserEntity user;
    private Set<ReplyEntity> replies=new HashSet<>();

    public int getPublishId() {
        return publishId;
    }

    public void setPublishId(int publishId) {
        this.publishId = publishId;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Set<ReplyEntity> getReplies() {
        return replies;
    }

    public void setReplies(Set<ReplyEntity> replies) {
        this.replies = replies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PublishEntity that = (PublishEntity) o;

        if (publishId != that.publishId) return false;
        if (pubContent != null ? !pubContent.equals(that.pubContent) : that.pubContent != null) return false;
        if (pubTime != null ? !pubTime.equals(that.pubTime) : that.pubTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = publishId;
        result = 31 * result + (pubContent != null ? pubContent.hashCode() : 0);
        result = 31 * result + (pubTime != null ? pubTime.hashCode() : 0);
        return result;
    }
}
