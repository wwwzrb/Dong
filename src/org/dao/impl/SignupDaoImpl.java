package org.dao.impl;

import org.dao.SignupDao;
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
public class SignupDaoImpl extends SuperDao implements SignupDao {

    @Override
    public boolean signUp(String username,String password){
        Session session=this.getSessionFactory().openSession();
        Transaction tx=null;
        UserEntity user=new UserEntity();
        try{
            tx=session.beginTransaction();
            Query query=session.createQuery("from UserEntity where userName=?");
            query.setParameter(0,username);
            query.setMaxResults(1);
            UserEntity u=(UserEntity)query.uniqueResult();
            if(u!=null){
                return false;
            }
            user.setUserName(username);
            user.setUserPwd(password);
            session.save(user);
            tx.commit();

        }
        catch (Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
            return false;
        }
        finally {
            session.close();
        }
        return true;

    }
}
