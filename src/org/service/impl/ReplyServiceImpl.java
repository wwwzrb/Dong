package org.service.impl;

import org.dao.PublishDao;
import org.dao.ReplyDao;
import org.dao.UserDao;
import org.service.ReplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wz on 2016/6/17.
 */
@Service
public class ReplyServiceImpl implements ReplyService {

    @Resource
    UserDao userDao;

    @Resource
    PublishDao publishDao;

    @Resource
    ReplyDao replyDao;

    @Override
    public boolean replyPublish(int userId,int publishId,String repContents){
         return replyDao.replyPublish(userDao.getUser(userId),publishDao.getPublish(publishId),repContents);
    }
}
