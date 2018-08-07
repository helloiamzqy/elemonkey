package com.monkey.ele.merchant.controller;

import com.monkey.ele.common.pojo.Message;
import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.common.util.Md5Utils;
import com.monkey.ele.merchant.pojo.User;
import com.monkey.ele.merchant.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseMessage login(@RequestBody User user) {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(user.getUsername(), Md5Utils.md5Password(user.getPassword())));
        User content = userService.findUserByUsername(user.getUsername());
        content.setComplains(null);
        content.setOrders(null);
        content.setContacts(null);
        content.setIdentity(null);
        content.setPassword(null);
        return new ResponseMessage(content, MessageResultCode.SUCCESS, "登录成功");
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST, consumes = "application/json")
    public ResponseMessage regist(@RequestBody User user){
        user.setPassword(Md5Utils.md5Password(user.getPassword()));
        User saveUser = userService.saveUser(user);
        ResponseMessage message = null;
        if(saveUser == null){
            message = new ResponseMessage(null,MessageResultCode.FAILED,Message.MSG_USER_REGIST_ERROR);
        }else{
            saveUser.setPassword(null);
            message = new ResponseMessage(saveUser,MessageResultCode.SUCCESS,Message.MSG_USER_REGIST_SUCCESS);
        }
        return message;
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseMessage deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return new ResponseMessage(null,MessageResultCode.SUCCESS,Message.MSG_DELETE_SUCCESS);
    }


    @GetMapping(value = "{id}")
    public ResponseMessage findUser(@PathVariable String id){
        return new ResponseMessage(userService.loadUser(id), MessageResultCode.SUCCESS, null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    public ResponseMessage updateUser(@RequestBody  User user){
        ResponseMessage message = null;
        User sqluser = userService.loadUser(user.getId());
        sqluser.setImage(user.getImage());
        User updateUser = userService.updateUser(sqluser);
        if(updateUser == null){
            message = new ResponseMessage(null, MessageResultCode.ERROR, Message.MSG_DELETE_ERROR);
        }else{
            updateUser.setPassword(null);
            message = new ResponseMessage(updateUser, MessageResultCode.SUCCESS, Message.MSG_UPDATE_SUCCESS);
        }
        return message;
    }



}
