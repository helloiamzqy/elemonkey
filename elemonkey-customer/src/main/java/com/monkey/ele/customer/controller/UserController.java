package com.monkey.ele.customer.controller;

import com.monkey.ele.common.security.util.JwtHelper;
import com.monkey.ele.customer.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/2/2018 10:47 AM
 **/
@RestController
public class UserController {

    @Autowired private JwtHelper jwtHelper;

    @RequestMapping("/login")
    public String login(User user, HttpServletResponse httpServletResponse) {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));

        if (subject.isAuthenticated()) {
            Map<String, String> payload = new HashMap<>();
            payload.put("id", user.getId());
            payload.put("username", user.getUsername());
            String jwtToken = jwtHelper.sign(payload);

            Cookie cookie = new Cookie("token", jwtToken);
            cookie.setHttpOnly(true);
            cookie.setDomain("localhost");
            cookie.setPath("/");
            cookie.setMaxAge(jwtHelper.TOKEN_EXPIRE_TIME);
            httpServletResponse.addCookie(cookie);
            return "login_success";
        } else {
            return "login_failed";
        }
    }

    @RequestMapping("/auth/hello")
    @RequiresAuthentication
    public String test() {
        return "hello world";
    }

}
