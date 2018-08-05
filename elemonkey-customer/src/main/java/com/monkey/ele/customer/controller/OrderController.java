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

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 查看历史订单
     * @return
     */
    @GetMapping(value = "user/history")
    @RequiresAuthentication
    public ResponseMessage findHistoryOrder(){
        List<Order> orders = orderService.findHistoryOrder((String) SecurityUtils.getSubject().getPrincipal());
        for(Order order:orders){
            order.getStoreInfo().setOrders(null);
            order.getStoreInfo().setProducts(null);
            order.getStoreInfo().setUser(null);
        }
        return new ResponseMessage(orders, MessageResultCode.SUCCESS, null);
    }


    /**
     * 查看正在进行的订单
     * @return
     */
    @GetMapping(value = "user/active")
    @RequiresAuthentication
    public ResponseMessage findActiveOrder(){
        List<Order> orders = orderService.findActiveOrder((String) SecurityUtils.getSubject().getPrincipal());
        for(Order order:orders){
            order.getStoreInfo().setOrders(null);
            order.getStoreInfo().setProducts(null);
            order.getStoreInfo().setUser(null);
        }
        return new ResponseMessage(orders, MessageResultCode.SUCCESS, null);
    }
}
