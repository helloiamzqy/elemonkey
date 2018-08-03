package com.monkey.ele.merchant.controller;
import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.merchant.pojo.Order;
import com.monkey.ele.merchant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PutMapping
    public ResponseMessage updateOrder(@RequestBody Order order){
        Order updateOrder = orderService.updateOrder(order);
        ResponseMessage message = null;
        if(updateOrder == null){
            message = new ResponseMessage(null,MessageResultCode.ERROR, Message.MSG_ADD_ERROR);
        }else{
            message = new ResponseMessage(updateOrder,MessageResultCode.SUCCESS, Message.MSG_UPDATE_SUCCESS);
        }
        return message;
    }

    @GetMapping(value = "/store/{id}")
    public ResponseMessage findOrderByStore(@PathVariable String id){
        return new ResponseMessage(orderService.findOrderByStoreId(id),MessageResultCode.SUCCESS, null);
    }
}
