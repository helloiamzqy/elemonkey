package com.monkey.ele.administrator.controller;

import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.administrator.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    private StoreService storeService;


    @GetMapping("stores/available")
    public List<Store> findAvailableStores(){
        return storeService.findAvailableStores();
    }

}
