package org.dao;

import org.vo.UserEntity;

import java.util.List;

/**
 * Created by wz on 2016/6/16.
 */
public interface FriendDao {
    boolean addFriend(UserEntity user,UserEntity friend);
    List<UserEntity> getMyfriend(UserEntity user);
}
