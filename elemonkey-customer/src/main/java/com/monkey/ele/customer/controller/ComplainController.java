package com.monkey.ele.customer.controller;

import com.monkey.ele.common.jms.JmsSender;
import com.monkey.ele.common.pojo.JMail;
import com.monkey.ele.common.pojo.Message;
import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.common.util.JsonUtil;
import com.monkey.ele.customer.pojo.Complain;
import com.monkey.ele.customer.pojo.User;
import com.monkey.ele.customer.service.ComplainService;
import com.monkey.ele.customer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/complain")
public class ComplainController {


    @Autowired
    private ComplainService complainService;
    @Autowired
    private JmsSender jmsSender;
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseMessage complain(@RequestBody Complain complain){
        Complain addComplain = complainService.addComplain(complain);
        User user = userService.findUserById(addComplain.getUserId());
        user.setOrders(null);
        user.setContacts(null);
        user.setComplains(null);
        addComplain.setUser(user);
        JMail jMail = new JMail(addComplain, JMail.JMailType.COMPLAIN_REQUEST);
        try {
            jmsSender.sendTextMessage(JsonUtil.obj2json(jMail));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResponseMessage message = null;
        if(addComplain == null){
            message = new ResponseMessage(null, MessageResultCode.ERROR, Message.MSG_ADD_ERROR);
        }else{
            message = new ResponseMessage(addComplain, MessageResultCode.SUCCESS, Message.MSG_ADD_SUCCESS);
        }
        return message;
    }
}
