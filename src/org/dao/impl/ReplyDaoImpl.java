package org.dao.impl;

import org.dao.ReplyDao;
import org.dao.SuperDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.vo.PublishEntity;
import org.vo.ReplyEntity;
import org.vo.UserEntity;

/**
 * Created by wz on 2016/6/17.
 */
@Repository
public class ReplyDaoImpl extends SuperDao implements ReplyDao {

    @Override
    public boolean replyPublish(UserEntity user, PublishEntity publish,String repContents){
        Session session=this.getSessionFactory().openSession();
        Transaction tx=null;
        ReplyEntity replyEntity=new ReplyEntity();
        try{
            tx=session.beginTransaction();
            replyEntity.setUser(user);
            replyEntity.setPublish(publish);
            replyEntity.setRepContents(repContents);
            session.save(replyEntity);
            tx.commit();
        }
        catch (Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }

        return true;
    }
}

