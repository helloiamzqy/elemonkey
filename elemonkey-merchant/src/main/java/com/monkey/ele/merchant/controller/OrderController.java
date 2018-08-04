package com.monkey.ele.merchant.controller;
import com.monkey.ele.common.pojo.Message;
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

    /**
     * 修改订单
     * 更新订单状态
     * @param order
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
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


    /**
     * 查看正在进行的订单的数量(已接单，配送中)
     * @param storeId
     * @return
     */
    @GetMapping(value = "active/store/{storeId}")
    public ResponseMessage getActiveOrderCount(@PathVariable String storeId){
        int orderCount = orderService.getActiveOrderCount(storeId);
        return new ResponseMessage(orderCount, MessageResultCode.SUCCESS, null);
    }

    /**
     * 查看新订单的数量(未接订单)
     * @param storeId
     * @return
     */
    @GetMapping(value = "new/store/{storeId}")
    public ResponseMessage getNewOrderCount(@PathVariable String storeId){
        int orderCount = orderService.getNewOrderCount(storeId);
        return new ResponseMessage(orderCount, MessageResultCode.SUCCESS, null);
    }
}
