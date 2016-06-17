package org.action;

import org.service.FriendService;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.vo.UserEntity;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by wz on 2016/6/17.
 */

@Controller
public class SearchAction extends ActionSupport implements ModelDriven {

    private UserEntity user;

    @Override
    public Object getModel(){
        if(user==null){
            user=new UserEntity();
        }
        return user;
    }

    @Resource
    FriendService friendService;

    public String execute() throws Exception{
        Map session = ActionContext.getContext().getSession();
        UserEntity search=friendService.searchUser(user.getUserName());
        session.put("search",search);
        return SUCCESS;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}
