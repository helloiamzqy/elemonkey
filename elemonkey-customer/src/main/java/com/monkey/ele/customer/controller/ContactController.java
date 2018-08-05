package com.monkey.ele.customer.controller;


import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.customer.pojo.Contact;
import com.monkey.ele.customer.service.ContectService;
import com.monkey.ele.customer.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contact")
public class ContactController {

    @Autowired
    private ContectService contectService;

    @Autowired
    private UserService userService;


    @GetMapping()
//    @RequiresAuthentication
    public Object getUserContact(){
        ResponseMessage resmsg = new ResponseMessage();
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken("skrskr","123456"));
        List<Contact> contacts = contectService.findContactByUser((String)subject.getPrincipal());
        resmsg.setContent(contacts);
        resmsg.setResultCode(MessageResultCode.SUCCESS);
        return resmsg;
    }


    @GetMapping("/del/{contactId}")
//    @RequiresAuthentication
    public Object delUserContact(@PathVariable(value="contactId") String contactId){
        ResponseMessage resmsg = new ResponseMessage();
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken("skrskr","123456"));
        boolean result = contectService.delContact((String)subject.getPrincipal(),contactId);
        resmsg.setResultCode(result?MessageResultCode.SUCCESS:MessageResultCode.ERROR);
        return resmsg;
    }


    @PostMapping()
//    @RequiresAuthentication
    public Object addUserContact(@RequestBody Contact contact){
        ResponseMessage resmsg = new ResponseMessage();
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken("skrskr","123456"));
        contact.setUserId((String)subject.getPrincipal());
        Contact dbContact = contectService.addContact(contact);
        resmsg.setContent(dbContact);
        resmsg.setResultCode(dbContact!=null?MessageResultCode.SUCCESS:MessageResultCode.ERROR);
        return resmsg;
    }


    @PostMapping(value = "/update" )
//    @RequiresAuthentication
    public Object updateUserContact(@RequestBody Contact contact){
        ResponseMessage resmsg = new ResponseMessage();
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken("skrskr","123456"));
        contact.setUserId((String)subject.getPrincipal());
        Contact dbContact = contectService.updateContact(contact);
        resmsg.setContent(dbContact);
        resmsg.setResultCode(dbContact!=null?MessageResultCode.SUCCESS:MessageResultCode.ERROR);
        return resmsg;
    }



}
