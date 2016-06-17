package org.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wz on 2016/6/14.
 */
public class GroupEntity {
    private int groupId;
    private String groupName;
    private Timestamp groTime;
    private UserEntity user;
    private Set<UserEntity> users=new HashSet<>();


    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Timestamp getGroTime() {
        return groTime;
    }

    public void setGroTime(Timestamp groTime) {
        this.groTime = groTime;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupEntity that = (GroupEntity) o;

        if (groupId != that.groupId) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (groTime != null ? !groTime.equals(that.groTime) : that.groTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (groTime != null ? groTime.hashCode() : 0);
        return result;
    }
}
