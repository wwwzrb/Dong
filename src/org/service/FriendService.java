package org.service;

import org.vo.UserEntity;

import java.util.List;

/**
 * Created by wz on 2016/6/17.
 */
public interface FriendService {
    boolean addFriend(int userId,int friendId);
    List<UserEntity> getMyfriend(int userId);
    UserEntity searchUser(String userName);
}
