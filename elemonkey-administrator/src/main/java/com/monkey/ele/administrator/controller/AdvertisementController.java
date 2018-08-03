package com.monkey.ele.administrator.controller;


import com.monkey.ele.administrator.pojo.Advertisement;
import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.administrator.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ads")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @PutMapping("{id}")
    public Advertisement updateAdStatus(@PathVariable("id") String id, @RequestBody Advertisement advertisement){
        return advertisementService.updateAdvertisement(advertisement);
    }

    @GetMapping
    public List<Advertisement> getAdvertisements(){
        return advertisementService.findAdvertisements();
    }


}
