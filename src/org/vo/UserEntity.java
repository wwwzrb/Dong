package org.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wz on 2016/6/14.
 */
public class UserEntity {
    private int userId;
    private String userName;
    private String userPwd;
    private Timestamp userTime;
    private Set<UserEntity> friends =new HashSet<>();
    private Set<PublishEntity> publish=new HashSet<>();
    private Set<GroupEntity> groups=new HashSet<>();
    private Set<ReplyEntity> replies=new HashSet<>();

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Timestamp getUserTime() {
        return userTime;
    }

    public void setUserTime(Timestamp userTime) {
        this.userTime = userTime;
    }

    public Set<UserEntity> getFriends() {
        return friends;
    }

    public void setFriends(Set<UserEntity> friends) {
        this.friends = friends;
    }

    public Set<PublishEntity> getPublish() {
        return publish;
    }

    public void setPublish(Set<PublishEntity> publish) {
        this.publish = publish;
    }

    public Set<GroupEntity> getGroups() {
        return groups;
    }

    public void setGroups(Set<GroupEntity> groups) {
        this.groups = groups;
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

        UserEntity that = (UserEntity) o;

        if (userId != that.userId) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userPwd != null ? !userPwd.equals(that.userPwd) : that.userPwd != null) return false;
        if (userTime != null ? !userTime.equals(that.userTime) : that.userTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPwd != null ? userPwd.hashCode() : 0);
        result = 31 * result + (userTime != null ? userTime.hashCode() : 0);
        return result;
    }
}
