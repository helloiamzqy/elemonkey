package com.monkey.ele.merchant.controller;

import com.monkey.ele.common.jms.JmsSender;
import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.common.util.JsonUtil;
import com.monkey.ele.merchant.pojo.Message;
import com.monkey.ele.merchant.pojo.Store;
import com.monkey.ele.merchant.pojo.StoreInformation;
import com.monkey.ele.merchant.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    public StoreController() {
        System.out.println("adsdd");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public ResponseMessage addStore(@RequestBody Store store) throws Exception {
        ResponseMessage respMsg = null;
        Store applyStore = storeService.applyStore(store);
        if (applyStore == null) {
            respMsg = new ResponseMessage(null, MessageResultCode.FAILED, Message.MSG_ADD_ERROR);
        } else {
            respMsg = new ResponseMessage(store, MessageResultCode.SUCCESS, Message.MSG_ADD_SUCCESS);
        }
        return respMsg;
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    public ResponseMessage update(@RequestBody Store store) {
        ResponseMessage respMsg = null;
        Store modifyStore = storeService.modifyStore(store);
        if (modifyStore == null) {
            respMsg = new ResponseMessage(null, MessageResultCode.FAILED, Message.MSG_UPDATE_ERROR);
        } else {
            respMsg = new ResponseMessage(store, MessageResultCode.SUCCESS, Message.MSG_UPDATE_SUCCESS);
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
