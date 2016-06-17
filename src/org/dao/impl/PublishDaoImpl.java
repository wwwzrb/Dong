package org.dao.impl;

import org.dao.PublishDao;
import org.dao.SuperDao;
import org.model.publishViewModel;
import org.model.replyViewModel;
import org.vo.PublishEntity;
import org.vo.ReplyEntity;
import org.vo.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wz on 2016/6/16.
 */
@Repository
public class PublishDaoImpl extends SuperDao implements PublishDao {

    @Override
    public boolean publishContent(UserEntity user,String pubContent){
        Session session=this.getSessionFactory().openSession();
        Transaction tx=null;
        PublishEntity publish=new PublishEntity();
        try{
            tx=session.beginTransaction();
            publish.setPubContent(pubContent);
            publish.setUser(user);
            session.save(publish);
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
    public PublishEntity getPublish(int publishId){
        Session session=this.getSessionFactory().openSession();
        Transaction tx=null;
        PublishEntity publish=new PublishEntity();
        try{
            tx=session.beginTransaction();
            publish=(PublishEntity)session.get(PublishEntity.class,publishId);
            tx.commit();
        }
        catch (Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }


        return publish;
    }

    @Override
    public List<publishViewModel> getUserpublish(UserEntity user){
        Session session=this.getSessionFactory().openSession();
        Transaction tx=null;
        List<publishViewModel> publishViewModels=new ArrayList<>();
        List<replyViewModel> replyViewModels;
        publishViewModel publishModel;
        replyViewModel replyModel;
        try{
            tx=session.beginTransaction();
            UserEntity user1=(UserEntity) session.get(UserEntity.class,user.getUserId());
            for(PublishEntity publish:user1.getPublish()){
                publishModel=new publishViewModel();
                publishModel.setPublishId(publish.getPublishId());
                publishModel.setUserId(publish.getUser().getUserId());
                publishModel.setPubContent(publish.getPubContent());
                publishModel.setUserName(publish.getUser().getUserName());
                publishModel.setPubTime(publish.getPubTime());
                replyViewModels=new ArrayList<>();
                for(ReplyEntity reply:publish.getReplies()){
                    replyModel=new replyViewModel();
                    replyModel.setUserId(reply.getUser().getUserId());
                    replyModel.setUserName(reply.getUser().getUserName());
                    replyModel.setRepContents(reply.getRepContents());
                    replyModel.setRepTime(reply.getRepTime());
                    replyViewModels.add(replyModel);
                }
                publishModel.setReply(replyViewModels);
                publishViewModels.add(publishModel);
            }
            tx.commit();
        }
        catch (Exception e){
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return  publishViewModels;
    }
}
