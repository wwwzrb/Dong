package org.action;

/**
 * Created by wz on 2016/6/16.
 */
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.service.PublishService;
import org.springframework.stereotype.Controller;
import org.vo.PublishEntity;
import org.vo.UserEntity;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class PublishAction extends ActionSupport implements ModelDriven{

    private UserEntity user;
    private PublishEntity publish;

    @Override
    public Object getModel(){
        if(publish==null)
            publish=new PublishEntity();
        return publish;
    }

    @Resource
    PublishService publishService;

    @Override
    public String execute() throws Exception{
        Map session = ActionContext.getContext().getSession();
        user=(UserEntity) session.get("user");
        if(publishService.publishContent(user,publish.getPubContent())){
            return SUCCESS;
        }
        else
            return ERROR;
    }

    public PublishEntity getPublish() {
        return publish;
    }

    public void setPublish(PublishEntity publish) {
        this.publish = publish;
    }
}
