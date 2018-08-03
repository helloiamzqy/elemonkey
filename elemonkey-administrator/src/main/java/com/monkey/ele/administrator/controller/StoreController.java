package com.monkey.ele.administrator.controller;

import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.administrator.service.StoreService;
import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.Page;
import com.monkey.ele.common.pojo.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping("{id}")
    public Object updateStoreStatus(@PathVariable("id") String id,@RequestBody Store store){
        Store st = storeService.updateStatus(store);
        ResponseMessage message = new ResponseMessage();
        message.setContent(st);
        message.setResultCode(st.getId()!=null ? MessageResultCode.SUCCESS : MessageResultCode.ERROR);
        return message;
    }


    @GetMapping("status/{status}")
    public Object getStores(@PathVariable("status") Integer status){
        List<Store> stores = storeService.findStores(status);
        ResponseMessage message = new ResponseMessage();
        message.setContent(stores);
        message.setResultCode(stores.size() > 0 ? MessageResultCode.SUCCESS : MessageResultCode.ERROR);
        return message;
    }


}
