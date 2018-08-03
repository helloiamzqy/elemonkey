package com.monkey.ele.administrator.controller;

import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.administrator.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PutMapping("{id}")
    public Store updateStoreStatus(@PathVariable("id") String id,@RequestBody Store store){
        return storeService.updateStatus(store);
    }




}
