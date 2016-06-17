package org.service;

/**
 * Created by wcy on 2016/5/24.
 */
import org.vo.UserEntity;

public interface SignService {
    UserEntity checkSignin(String username, String password);
    boolean signUp(String username, String password);
}
