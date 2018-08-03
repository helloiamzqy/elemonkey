package com.monkey.ele.customer.controller;

import com.monkey.ele.common.pojo.Message;
import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.customer.pojo.Order;
import com.monkey.ele.customer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseMessage createOrder(@RequestBody Order order){
        Order saveOrder = orderService.createOrder(order);
        ResponseMessage message = null;
        if(saveOrder == null){
            message = new ResponseMessage(null, MessageResultCode.ERROR, Message.MSG_ADD_ERROR);
        }else{
            message = new ResponseMessage(saveOrder, MessageResultCode.SUCCESS, Message.MSG_ADD_SUCCESS);
        }
        return message;
    }
}
