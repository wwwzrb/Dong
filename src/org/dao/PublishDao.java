package org.dao;

/**
 * Created by wz on 2016/6/16.
 */
import org.model.publishViewModel;
import org.vo.PublishEntity;
import org.vo.UserEntity;

import java.util.List;

public interface PublishDao {
    boolean publishContent(UserEntity user,String pubContent);
    PublishEntity getPublish(int publishId);
    List<publishViewModel> getUserpublish(UserEntity user);
}
