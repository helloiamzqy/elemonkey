package com.monkey.ele.administrator.controller;

import com.monkey.ele.administrator.pojo.Advertisement;
import com.monkey.ele.administrator.pojo.Complain;
import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.administrator.service.ComplainService;
import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.Page;
import com.monkey.ele.common.pojo.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("complains")
public class ComplainController {

    @Autowired
    private ComplainService complainService;


    @PostMapping("{id}")
    public Object updateComplainStatus(@PathVariable("id") String id, @RequestBody Complain complain){
        Complain cp = complainService.updateComplain(complain);
        ResponseMessage message = new ResponseMessage();
        message.setContent(cp);
        message.setResultCode(cp.getId()!=null ? MessageResultCode.SUCCESS : MessageResultCode.ERROR);
        return message;
    }

    @GetMapping("status/{status}")
    public Object getComplains(@PathVariable("status") Integer status,Integer pageIndex,Integer pageCount){
        Page<Complain> page = complainService.findComplainsPageByStatus(status,pageIndex,pageCount);
        ResponseMessage message = new ResponseMessage();
        message.setContent(page);
        message.setResultCode(MessageResultCode.SUCCESS);
        return message;
    }


}
