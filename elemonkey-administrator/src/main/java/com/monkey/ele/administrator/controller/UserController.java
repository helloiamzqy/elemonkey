package com.monkey.ele.administrator.controller;

import com.monkey.ele.administrator.pojo.User;
import com.monkey.ele.administrator.service.UserService;
import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.common.util.Md5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
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
}
