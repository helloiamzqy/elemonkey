package com.monkey.ele.customer.controller;

import com.monkey.ele.common.pojo.Message;
import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.customer.pojo.Order;
import com.monkey.ele.customer.service.OrderService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 提交订单
     * @param order
     * @return
     */
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

    /**
     * 查看历史订单
     * @return
     */
    @GetMapping(value = "user/history")
    @RequiresAuthentication
    public ResponseMessage findHistoryOrder(){
        return new ResponseMessage(orderService.findHistoryOrder((String) SecurityUtils.getSubject().getPrincipal()), MessageResultCode.SUCCESS, null);
    }


    /**
     * 查看正在进行的订单
     * @return
     */
    @GetMapping(value = "user/active")
    @RequiresAuthentication
    public ResponseMessage findActiveOrder(){
        return new ResponseMessage(orderService.findActiveOrder((String) SecurityUtils.getSubject().getPrincipal()), MessageResultCode.SUCCESS, null);
    }
}
