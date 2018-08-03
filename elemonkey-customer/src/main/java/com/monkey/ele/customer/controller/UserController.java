package com.monkey.ele.customer.controller;

import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.customer.pojo.User;
import com.monkey.ele.customer.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/2/2018 10:47 AM
 **/
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired private UserService userService;

    @PostMapping("/login")
    public ResponseMessage login(@RequestBody User user) {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));
        User content = userService.findUserByUsername(user.getUsername());
        content.setComplains(null);
        content.setOrders(null);
        content.setContacts(null);
        content.setIdentity(null);
        content.setPassword(null);
        return new ResponseMessage(content, MessageResultCode.SUCCESS, "登录成功");
    }

    @RequestMapping("/logout")
    public ResponseMessage logout() {
        SecurityUtils.getSubject().logout();
        return new ResponseMessage(null, MessageResultCode.SUCCESS, "登出成功");
    }

    @PostMapping("/register")
    public ResponseMessage register(@RequestBody User user) {
        if (userService.findUserByUsername(user.getUsername()) != null) {
            return new ResponseMessage(null, MessageResultCode.FAILED, "该用户名已存在");
        }
        userService.save(user);
        return new ResponseMessage(null, MessageResultCode.SUCCESS, "注册成功");
    }

}
