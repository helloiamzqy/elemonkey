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

    @PutMapping("{id}")
    public Store updateStoreStatus(@PathVariable("id") String id,@RequestBody Store store){
        return storeService.updateStatus(store);
    }

    @GetMapping
    public Object getStores(){
        ResponseMessage message = new ResponseMessage();
        Page page = new Page();
        page.setPageIndex(1);
        page.setPageCount(2);
        message.setContent(storeService.findStoresPage(page));
        message.setResultCode(MessageResultCode.SUCCESS);
        return message;
    }


}
