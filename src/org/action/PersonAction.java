package org.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.model.publishViewModel;
import org.service.PublishService;
import org.springframework.stereotype.Controller;
import org.vo.UserEntity;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by wz on 2016/6/16.
 */
@Controller
public class PersonAction extends ActionSupport implements ModelDriven {

    private UserEntity user;

    @Override
    public Object getModel(){
        if(user==null){
            user=new UserEntity();
        }
        return user;
    }

    @Resource
    PublishService publishService;

    public String execute() throws Exception{
        Map session = ActionContext.getContext().getSession();
        List<publishViewModel> publishViewModels;
        user=(UserEntity)session.get("user");
        publishViewModels=publishService.getUserpublish(user.getUserId());
        session.put("person",publishViewModels);
        return SUCCESS;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
