package org.service.impl;

/**
 * Created by wz on 2016/6/16.
 */
import org.dao.FriendDao;
import org.dao.UserDao;
import org.model.publishViewModel;
import org.model.replyViewModel;
import org.service.PublishService;
import org.springframework.stereotype.Service;
import org.vo.PublishEntity;
import org.vo.ReplyEntity;
import org.vo.UserEntity;
import org.dao.PublishDao;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PublishServiceImpl implements PublishService{
    @Resource
    PublishDao publishDao;
    @Resource
    UserDao userDao;
    @Resource
    FriendDao friendDao;



    @Override
    public boolean publishContent(UserEntity user,String pubContent){
        return publishDao.publishContent(user,pubContent);
    }

    @Override
    public List<publishViewModel> getUserpublish(int userId){
        UserEntity user=userDao.getUser(userId);
        return publishDao.getUserpublish(user);
    }
    @Override
    public List<publishViewModel> getFriendpublish(int userId){
        List<publishViewModel> publishViewModels=new ArrayList<>();
        List<UserEntity> friends=friendDao.getMyfriend(userDao.getUser(userId));
        for(UserEntity user:friends){
            publishViewModels.addAll(publishDao.getUserpublish(user));
        }
        return publishViewModels;
    }
}
