package org.dao.impl;

import org.dao.SigninDao;
import org.dao.SuperDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.vo.UserEntity;

/**
 * Created by wcy on 2016/5/26.
 */

@Repository
public class SigninDaoImpl extends SuperDao implements SigninDao {

    @Override
    public UserEntity checkSignin(String username, String password){
        Session session=this.getSessionFactory().openSession();
        Transaction tx=null;
        UserEntity user=null;
        try{
            tx=session.beginTransaction();
            Query query=session.createQuery("from UserEntity where userName=? and userPwd=?");
            query.setParameter(0,username);
            query.setParameter(1,password);
            query.setMaxResults(1);
            user=(UserEntity)query.uniqueResult();
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
