package org.dao.impl;

import org.dao.SuperDao;
import org.dao.UserDao;

/**
 * Created by wz on 2016/6/16.
 */
import org.hibernate.Query;
import org.vo.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl extends SuperDao implements UserDao {

    @Override
    public UserEntity getUser(int userId){
        Session session=this.getSessionFactory().openSession();
        Transaction tx=null;
        UserEntity user=new UserEntity();
        try{
            tx=session.beginTransaction();
            user=(UserEntity)session.get(UserEntity.class,userId);
            tx.commit();
        }
        catch (Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }


        return user;
    }

    @Override
    public UserEntity searchUser(String userName){
        Session session=this.getSessionFactory().openSession();
        Transaction tx=null;
        UserEntity user=new UserEntity();
        try{
            tx=session.beginTransaction();
            Query query=session.createQuery("from UserEntity where userName=?");
            query.setParameter(0,userName);
            query.setMaxResults(1);
            user=(UserEntity) query.uniqueResult();
            tx.commit();
        }
        catch (Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }


        return user;
    }

}
