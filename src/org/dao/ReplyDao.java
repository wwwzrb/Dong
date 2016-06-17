package org.dao;

import org.vo.PublishEntity;
import org.vo.UserEntity;

/**
 * Created by wz on 2016/6/17.
 */
public interface ReplyDao {
    boolean replyPublish(UserEntity user,PublishEntity publish,String repContents);
}
