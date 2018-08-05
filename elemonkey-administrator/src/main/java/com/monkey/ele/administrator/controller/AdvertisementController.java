package com.monkey.ele.administrator.controller;


import com.monkey.ele.administrator.pojo.Advertisement;
import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.administrator.service.AdvertisementService;
import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.Page;
import com.monkey.ele.common.pojo.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ads")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    /**
     * 更新广告审核状态
     * @param id
     * @param advertisement
     * @return
     */
    @PostMapping("{id}")
    public Object updateAdStatus(@PathVariable("id") String id, @RequestBody Advertisement advertisement){
        return new ResponseMessage(advertisementService.updateAdvertisement(advertisement),MessageResultCode.SUCCESS,null);
    }

    /**
     * 根据审核状态、获取广告分页
     * @param status
     * @param pageIndex
     * @param pageCount
     * @return
     */
    @GetMapping("/status/{status}")
    public Object getAdvertisements(@PathVariable("status") Integer status,Integer pageIndex,Integer pageCount){
        return new ResponseMessage(advertisementService.findAdvertisementsPageByStatus(status,pageIndex,pageCount),MessageResultCode.SUCCESS,null);
    }

    /**
     * 获取各种审核状态的广告数量
     * @return
     */
    @GetMapping("/countStatus")
    public Object getCountAllKindsStatus(){
        return new ResponseMessage(advertisementService.countAdStatus(),MessageResultCode.SUCCESS,null);
    }

}
