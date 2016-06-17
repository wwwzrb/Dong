package org.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.service.PublishService;
import org.springframework.stereotype.Controller;
import org.model.publishViewModel;
import org.vo.UserEntity;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by wz on 2016/6/17.
 */
@Controller
public class HomeAction extends ActionSupport{

    private int userId;

    @Resource
    PublishService publishService;

    @Override
    public String execute(){
        Map session = ActionContext.getContext().getSession();
        userId=((UserEntity)session.get("user")).getUserId();
        List<publishViewModel> home=publishService.getFriendpublish(userId);
        session.put("home",home);
        return SUCCESS;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
