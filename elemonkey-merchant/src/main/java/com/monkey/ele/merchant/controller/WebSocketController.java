package com.monkey.ele.merchant.controller;

import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.merchant.websocket.handler.MerchantSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

import java.util.Map;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 9:34 AM 8/3/2018
 */
@RestController
@RequestMapping("/websocket")
public class WebSocketController {
    @Autowired
    MerchantSocketHandler customerSocketHandler;

    @RequestMapping(value = "/push", method = RequestMethod.POST, consumes = "application/json;charset=utf-8" )
    public ResponseMessage pushMsg(@RequestBody Map<String, String> map) {
        boolean flag = customerSocketHandler.sendMessageToUser("111", new TextMessage(map.get("data")));
        if (flag) {
            return new ResponseMessage(null, MessageResultCode.SUCCESS, null);
        } else {
            return new ResponseMessage(null, MessageResultCode.FAILED, null);
        }
    }

}
