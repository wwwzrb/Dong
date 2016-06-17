package org.vo;

import java.sql.Timestamp;

/**
 * Created by wz on 2016/6/14.
 */
public class FriendEntity {
    private int id;
    private Timestamp friendTime;
    private UserEntity user;
    private UserEntity friend;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFriendTime() {
        return friendTime;
    }

    public void setFriendTime(Timestamp friendTime) {
        this.friendTime = friendTime;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public UserEntity getFriend() {
        return friend;
    }

    public void setFriend(UserEntity friend) {
        this.friend = friend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FriendEntity that = (FriendEntity) o;

        if (id != that.id) return false;
        if (friendTime != null ? !friendTime.equals(that.friendTime) : that.friendTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (friendTime != null ? friendTime.hashCode() : 0);
        return result;
    }
}
