package com.monkey.ele.customer.controller;

import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.common.util.Md5Utils;
import com.monkey.ele.customer.pojo.Contact;
import com.monkey.ele.customer.pojo.User;
import com.monkey.ele.customer.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/2/2018 10:47 AM
 **/
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired private UserService userService;

    private static final String OLD_PWD_NAME = "oldpassword";
    private static final String NEW_PWD_NAME = "newpassword";

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
        user.setPassword(Md5Utils.md5Password(user.getPassword()));
        userService.save(user);
        return new ResponseMessage(null, MessageResultCode.SUCCESS, "注册成功");
    }

    @RequiresAuthentication
    @PostMapping("/changePwd")
    public ResponseMessage changPwd(@RequestBody Map<String,String> pwdMap) {
        Integer resultCode = MessageResultCode.SUCCESS;
        String msg = null;
        User user = userService.findUserById((String)SecurityUtils.getSubject().getPrincipal());
        if(user.getPassword().equals(Md5Utils.md5Password(pwdMap.get(OLD_PWD_NAME)))){
            user.setPassword(Md5Utils.md5Password(pwdMap.get(NEW_PWD_NAME)));
            userService.updateUser(user);
            msg = "密码修改成功";
        }
        else {
            resultCode = MessageResultCode.FAILED;
            msg = "密码错误";
        }
        return new ResponseMessage(null, resultCode, msg);
    }


    @RequiresAuthentication
    @PostMapping("/changeLogo")
    public ResponseMessage changLogo(@RequestBody User jsonuser) {
        User user = userService.findUserById((String)SecurityUtils.getSubject().getPrincipal());
        user.setImage(jsonuser.getImage());
        userService.updateUser(user);
        return new ResponseMessage(user.getImage(), MessageResultCode.SUCCESS, null);
    }

}
