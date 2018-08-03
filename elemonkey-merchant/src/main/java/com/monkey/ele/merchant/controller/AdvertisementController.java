package com.monkey.ele.merchant.controller;

import com.monkey.ele.common.pojo.Message;
import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.merchant.pojo.Advertisement;
import com.monkey.ele.merchant.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ad")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    /**
     * JMS发送广告推荐
     * @param advertisement
     * @return
     */
    @RequestMapping(value = "/send", method = RequestMethod.POST, consumes = "application/json")
    public ResponseMessage sendAdvertisement(@RequestBody Advertisement advertisement){
        advertisementService.sendAdvertisement(advertisement);
        return new ResponseMessage(null,MessageResultCode.SUCCESS,Message.MSG_ADD_SUCCESS);
    }
}
