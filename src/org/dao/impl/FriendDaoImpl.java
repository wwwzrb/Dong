package org.dao.impl;

import org.dao.FriendDao;
import org.dao.SuperDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.vo.FriendEntity;
import org.vo.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wz on 2016/6/17.
 */
@Repository
public class FriendDaoImpl extends SuperDao implements FriendDao {

    @Override
    public boolean addFriend(UserEntity user,UserEntity friend){
        Session session=this.getSessionFactory().openSession();
        Transaction tx=null;
        FriendEntity friendEntity=new FriendEntity();
        try{
            tx=session.beginTransaction();
            Query query=session.createQuery("from FriendEntity where user.userId=? and friend.userId=?");
            query.setParameter(0,user.getUserId());
            query.setParameter(1,friend.getUserId());
            query.setMaxResults(1);
            FriendEntity exist=(FriendEntity)query.uniqueResult();
            if(exist!=null){
                return false;
            }
            friendEntity.setUser(user);
            friendEntity.setFriend(friend);
            session.save(friendEntity);
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

    @Override
    public List<UserEntity> getMyfriend(UserEntity user){
        Session session=this.getSessionFactory().openSession();
        Transaction tx=null;
        List<UserEntity> friends=new ArrayList<>();
        UserEntity user1;
        try{
            tx=session.beginTransaction();
            user1=(UserEntity) session.get(UserEntity.class,user.getUserId());
            friends.addAll(user1.getFriends());
            tx.commit();
        }
        catch (Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return friends;
    }
}
