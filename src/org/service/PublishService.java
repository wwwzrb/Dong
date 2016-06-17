package org.service;

import org.model.publishViewModel;
import org.vo.UserEntity;

import java.util.List;

/**
 * Created by wz on 2016/6/16.
 */
public interface PublishService {
    boolean publishContent(UserEntity user,String pubContent);
    List<publishViewModel> getUserpublish(int userId);
    List<publishViewModel> getFriendpublish(int userId);
}
