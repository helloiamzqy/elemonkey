package com.monkey.ele.customer.controller;

import com.monkey.ele.common.pojo.Message;
import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.customer.pojo.Complain;
import com.monkey.ele.customer.service.ComplainService;
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

    @PostMapping
    public ResponseMessage complain(@RequestBody Complain complain){
        Complain addComplain = complainService.addComplain(complain);
        ResponseMessage message = null;
        if(addComplain == null){
            message = new ResponseMessage(null, MessageResultCode.ERROR, Message.MSG_ADD_ERROR);
        }else{
            message = new ResponseMessage(addComplain, MessageResultCode.SUCCESS, Message.MSG_ADD_SUCCESS);
        }
        return message;
    }
}
