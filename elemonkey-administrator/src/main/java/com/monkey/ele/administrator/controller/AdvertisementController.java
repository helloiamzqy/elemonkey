package com.monkey.ele.administrator.controller;


import com.monkey.ele.administrator.pojo.Advertisement;
import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.administrator.service.AdvertisementService;
import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ads")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @PostMapping("{id}")
    public Object updateAdStatus(@PathVariable("id") String id, @RequestBody Advertisement advertisement){
        Advertisement ad = advertisementService.updateAdvertisement(advertisement);
        ResponseMessage message = new ResponseMessage();
        message.setContent(ad);
        message.setResultCode(ad.getId()!=null ? MessageResultCode.SUCCESS : MessageResultCode.ERROR);
        return message;
    }

    @GetMapping("/status/{status}")
    public Object getAdvertisements(@PathVariable("status") Integer status){
        List<Advertisement> ads = advertisementService.findAdvertisements(status);
        ResponseMessage message = new ResponseMessage();
        message.setContent(ads);
        message.setResultCode(ads.size() > 0 ? MessageResultCode.SUCCESS : MessageResultCode.ERROR);
        return message;
    }


}
