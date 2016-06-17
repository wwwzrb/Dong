package org.service.impl;

/**
 * Created by wcy on 2016/5/24.
 */

import org.dao.SigninDao;
import org.dao.SignupDao;
import org.service.SignService;
import org.springframework.stereotype.Service;
import org.vo.UserEntity;

import javax.annotation.Resource;

@Service
public class SignServiceImpl implements SignService {
    @Resource
    private SigninDao signinDao;
    @Resource
    private SignupDao signupDao;
    @Override
    public UserEntity checkSignin(String username, String password){
        return this.signinDao.checkSignin(username,password);
    }
    @Override
    public boolean signUp(String username,String password){
        return this.signupDao.signUp(username,password);
    }

}
