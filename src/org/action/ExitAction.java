package org.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * Created by wz on 2016/6/17.
 */
@Controller
public class ExitAction extends ActionSupport {

    @Override
    public String execute(){
        Map session = ActionContext.getContext().getSession();
        session.clear();
        return SUCCESS;
    }
}
