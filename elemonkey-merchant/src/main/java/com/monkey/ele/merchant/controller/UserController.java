package com.monkey.ele.merchant.controller;

import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.merchant.pojo.Message;
import com.monkey.ele.merchant.pojo.User;
import com.monkey.ele.merchant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseMessage regisiter(@RequestBody User user){
        User saveUser = userService.saveUser(user);
        ResponseMessage message = null;
        if(saveUser == null){
            message = new ResponseMessage(saveUser,MessageResultCode.FAILED,Message.MSG_USER_REGIST_ERROR);
        }else{
            message = new ResponseMessage(saveUser,MessageResultCode.SUCCESS,Message.MSG_USER_REGIST_SUCCESS);
        }
        return message;
    }


    @DeleteMapping(value = "{id}")
    public ResponseMessage deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return new ResponseMessage(null,MessageResultCode.SUCCESS,Message.MSG_DELETE_SUCCESS);
    }


    @GetMapping(value = "{id}")
    public ResponseMessage findUser(@PathVariable String id){
        User user = userService.loadUser(id);
        return new ResponseMessage(user, MessageResultCode.SUCCESS, null);
    }

    @PutMapping
    public ResponseMessage updateUser(@RequestBody  User user){
        ResponseMessage message = null;
        User updateUser = userService.updateUser(user);
        if(updateUser == null){
            message = new ResponseMessage(updateUser, MessageResultCode.ERROR, Message.MSG_DELETE_ERROR);
        }else{
            message = new ResponseMessage(updateUser, MessageResultCode.SUCCESS, Message.MSG_UPDATE_SUCCESS);
        }
        return message;
    }



}