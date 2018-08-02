package com.monkey.ele.customer.controller;

import com.monkey.ele.customer.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/2/2018 10:47 AM
 **/
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));
        if (subject.isAuthenticated()) {
            return "login_success";
        } else {
            return "login_failed";
        }
    }

    @GetMapping
    public String logout() {
        SecurityUtils.getSubject().logout();
        return null;
    }

}
