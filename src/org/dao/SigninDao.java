package org.dao;

/**
 *Created by wcy on 2016/5/24.
 */

import org.vo.UserEntity;

public interface SigninDao {
    UserEntity checkSignin(String username, String password);
}
