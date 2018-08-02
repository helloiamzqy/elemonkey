package com.monkey.ele.customer.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contact")
public class ContactController {

    @GetMapping("/")
    public Object getUserContact(){
        Subject subject = SecurityUtils.getSubject();
        Object object = subject.getPrincipal();
        return null;
    }



}
