package org.action;

/**
 * Created by wcy on 2016/5/26.
 */
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.service.SignService;
import org.springframework.stereotype.Controller;
import org.vo.UserEntity;

import javax.annotation.Resource;

@Controller
public class SignupAction extends ActionSupport implements ModelDriven {

    private UserEntity user;

    @Override
    public Object getModel()
    {
        if (user == null)
            user = new UserEntity();
        return user;
    }
    @Resource
    private SignService signService;
    @Override
    public String execute() throws Exception
    {
        if(this.signService.signUp(user.getUserName(),user.getUserPwd()))
            return SUCCESS;
        else
            return ERROR;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
