package org.service;

/**
 * Created by wz on 2016/6/17.
 */
public interface ReplyService {
    boolean replyPublish(int userId,int publishId,String repContents);
}
