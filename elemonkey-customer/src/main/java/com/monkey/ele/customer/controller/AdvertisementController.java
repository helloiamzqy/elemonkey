package com.monkey.ele.customer.controller;

import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.customer.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/3/2018 5:07 PM
 **/
@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {

    @Autowired private AdvertisementService advertisementService;

    @GetMapping
    public ResponseMessage index() throws Exception {
        return new ResponseMessage(advertisementService.findAdvertisementsLimit(6), MessageResultCode.SUCCESS, "查询成功");
    }


}
