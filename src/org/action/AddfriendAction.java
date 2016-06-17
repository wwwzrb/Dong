package org.action;

import com.opensymphony.xwork2.ActionSupport;
import org.service.FriendService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by wz on 2016/6/17.
 */
@Controller
public class AddfriendAction extends ActionSupport{

    private int userId;
    private int friendId;

    @Resource
    FriendService friendService;

    @Override
    public  String execute(){
        if(userId==friendId)
            return ERROR;
        if(friendService.addFriend(userId,friendId))
            return SUCCESS;
        else
            return ERROR;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }
}
