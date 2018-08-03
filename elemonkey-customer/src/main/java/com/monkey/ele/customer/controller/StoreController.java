package com.monkey.ele.customer.controller;

import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.customer.pojo.ComplexStore;
import com.monkey.ele.customer.service.ComplexStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("store")
public class StoreController {


    @Autowired
    ComplexStoreService storeService;



    @GetMapping("/")
    public Object getPassStore(Integer firstIndex, Integer maxResults){
        ResponseMessage resMsg = new ResponseMessage();
        resMsg.setContent((firstIndex==null&&maxResults==null)?
                storeService.findPassStore():storeService.findPassStorePage(firstIndex,maxResults));
        resMsg.setResultCode(MessageResultCode.SUCCESS);
        return resMsg;
    }



}
