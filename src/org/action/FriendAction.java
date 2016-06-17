package org.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.service.FriendService;
import org.springframework.stereotype.Controller;
import org.vo.UserEntity;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by wz on 2016/6/17.
 */

@Controller
public class FriendAction extends ActionSupport implements ModelDriven{

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
        List<UserEntity> friend=friendService.getMyfriend(user.getUserId());
        session.put("friend",friend);
        session.put("search",null);
        return SUCCESS;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}
