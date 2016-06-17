package org.action;

import com.opensymphony.xwork2.ActionSupport;
import org.service.ReplyService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by wz on 2016/6/17.
 */
@Controller
public class ReplypubAction extends ActionSupport{
    private int userId;
    private int publishId;
    private String repContents;
    private int page;

    @Resource
    ReplyService replyService;

    @Override
    public String execute(){
        if(replyService.replyPublish(userId,publishId,repContents)){
            if(page==0)
                return "home";
            else
                return "person";
        }
        if(page==0)
            return "home";
        else
            return "person";
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPublishId() {
        return publishId;
    }

    public void setPublishId(int publishId) {
        this.publishId = publishId;
    }

    public String getRepContents() {
        return repContents;
    }

    public void setRepContents(String repContents) {
        this.repContents = repContents;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
