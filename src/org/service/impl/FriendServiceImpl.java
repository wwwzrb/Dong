package org.service.impl;

import org.dao.FriendDao;
import org.dao.UserDao;
import org.service.FriendService;
import org.springframework.stereotype.Service;
import org.vo.UserEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wz on 2016/6/17.
 */
@Service
public class FriendServiceImpl implements FriendService{

    @Resource
    FriendDao friendDao;
    @Resource
    UserDao userDao;

    @Override
    public boolean addFriend(int userId,int friendId){
        return friendDao.addFriend(userDao.getUser(userId),userDao.getUser(friendId));
    }

    @Override
    public List<UserEntity> getMyfriend(int userId){
        return friendDao.getMyfriend(userDao.getUser(userId));
    }

    @Override
    public UserEntity searchUser(String userName){
        return userDao.searchUser(userName);
    }

}
