package com.monkey.ele.merchant.controller;

import com.monkey.ele.common.jms.JmsSender;
import com.monkey.ele.common.pojo.Message;
import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.merchant.pojo.Store;
import com.monkey.ele.merchant.pojo.StoreInformation;
import com.monkey.ele.merchant.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 9:04 AM 8/2/2018
 */
@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;
    @Autowired
    private JmsSender jmsSender;

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public ResponseMessage addStore(@RequestBody Store store) throws Exception {
        ResponseMessage respMsg = null;
        Store addStore = storeService.addStore(store);
        storeService.applyStore(store);
        if (addStore == null) {
            respMsg = new ResponseMessage(null, MessageResultCode.FAILED, Message.MSG_ADD_ERROR);
        } else {
            respMsg = new ResponseMessage(store, MessageResultCode.SUCCESS, Message.MSG_ADD_SUCCESS);
        }
        return respMsg;
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    public ResponseMessage update(@RequestBody Store store) {
        ResponseMessage respMsg = null;
        Store loadStore = storeService.watchStore(store.getId());
        loadStore.setStoreInformation(store.getStoreInformation());
        Store modifyStore = storeService.modifyStore(loadStore);
        modifyStore.setOrders(null);
        modifyStore.setProducts(null);
        modifyStore.setUser(null);
        if (modifyStore == null) {
            respMsg = new ResponseMessage(null, MessageResultCode.FAILED, Message.MSG_UPDATE_ERROR);
        } else {
            respMsg = new ResponseMessage(modifyStore, MessageResultCode.SUCCESS, Message.MSG_UPDATE_SUCCESS);
        }
        return respMsg;
    }

    @RequestMapping(value = "/{storeId}/info/update", method = RequestMethod.POST, consumes = "application/json")
    public ResponseMessage updateStoreInfo(@PathVariable("storeId") String storeId, @RequestBody StoreInformation storeInfo) {
        ResponseMessage respMsg = null;
        StoreInformation modifyStoreInfo = storeService.modifyStoreInfo(storeId, storeInfo);
        if (modifyStoreInfo == null) {
            respMsg = new ResponseMessage(null, MessageResultCode.FAILED, Message.MSG_UPDATE_ERROR);
        } else {
            respMsg = new ResponseMessage(modifyStoreInfo, MessageResultCode.SUCCESS, Message.MSG_UPDATE_SUCCESS);
        }
        return respMsg;
    }

    @RequestMapping(value = "/{storeId}", method = RequestMethod.GET)
    public ResponseMessage getStore(@PathVariable("storeId") String storeId) {
        ResponseMessage respMsg = null;
        Store store = storeService.watchStore(storeId);
        store.setOrders(null);
        store.setProducts(null);
        store.setUser(null);
        respMsg = new ResponseMessage(store, MessageResultCode.SUCCESS, null);
        return respMsg;
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public ResponseMessage getStoreByUserId(@PathVariable("userId") String userId) {
        ResponseMessage respMsg = null;
        Store store = storeService.watchStoreByUserId(userId);
        respMsg = new ResponseMessage(store, MessageResultCode.SUCCESS, null);
        return respMsg;
    }

    @RequestMapping(value = "/{storeId}/info", method = RequestMethod.GET)
    public ResponseMessage getStoreInfo(@PathVariable("storeId") String storeId) {
        ResponseMessage respMsg = null;
        StoreInformation storeInfo = storeService.watchStoreInfo(storeId);
        respMsg = new ResponseMessage(storeInfo, MessageResultCode.SUCCESS, null);
        return respMsg;
    }
}
