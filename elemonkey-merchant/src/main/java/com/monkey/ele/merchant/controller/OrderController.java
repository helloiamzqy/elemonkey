package com.monkey.ele.merchant.controller;
import com.monkey.ele.common.pojo.Message;
import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.Page;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.merchant.pojo.Order;
import com.monkey.ele.merchant.service.OrderService;
import com.monkey.ele.merchant.websocket.handler.MerchantSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.TextMessage;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    MerchantSocketHandler merchantSocketHandler;

    /**
     * 添加新订单，级联添加订单项
     * @param order
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public ResponseMessage addOrder(@RequestBody Order order){
        Order addOrder = orderService.addOrder(order);
        ResponseMessage message = null;
        if(addOrder == null){
            message = new ResponseMessage(null,MessageResultCode.ERROR, Message.MSG_ADD_ERROR);
        }else{
            message = new ResponseMessage(addOrder,MessageResultCode.SUCCESS, Message.MSG_ADD_SUCCESS);
        }
        merchantSocketHandler.sendMessageToUser("111", new TextMessage("你有新的外卖订单"));
        return message;
    }


    /**
     * 修改订单状态
     * @param orderId 订单id
     * @param status 订单状态
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    public ResponseMessage updateOrder(@RequestBody String orderId, @RequestBody Integer status){
        Order order = orderService.findOrderById(orderId);
        order.setStatus(status);
        Order updateOrder = orderService.updateOrder(order);
        ResponseMessage message = null;
        if(updateOrder == null){
            message = new ResponseMessage(null,MessageResultCode.ERROR, Message.MSG_UPDATE_ERROR);
        }else{
            message = new ResponseMessage(updateOrder,MessageResultCode.SUCCESS, Message.MSG_UPDATE_SUCCESS);
        }
        return message;
    }

    /**
     * 分页查看商家的全部订单
     * @param id 商家ID
     * @param page 当前页数
     * @param pageSize 每页订单数
     * @return
     */
    @GetMapping(value = "/store/{id}")
    public ResponseMessage findOrderByStore(@PathVariable String id,Integer page,Integer pageSize){
        if(page == null || page <= 1){
            page = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        Page<Order> orderPage = orderService.findOrderByStoreId(id, page, pageSize);
        return new ResponseMessage(orderPage,MessageResultCode.SUCCESS, null);

    }

    /**
     * 分页查看商家的指定订单状态的订单
     * @param storeId 商家ID
     * @param status 订单状态
     * @param page 当前页数
     * @param pageSize 每页的订单数
     * @return
     */
    @GetMapping(value = "/store/{storeId}/status/{status}")
    public ResponseMessage findOrderByStatus(@PathVariable String storeId,@PathVariable Integer status, Integer page, Integer pageSize){
        if(page == null || page <= 1){
            page = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        Page<Order> orderPage = orderService.findOrderByStatus(storeId, status, page, pageSize);
        return new ResponseMessage(orderPage,MessageResultCode.SUCCESS, null);
    }


    /**
     * 查看正在进行的订单的数量(已接单，配送中)
     * @param storeId
     * @return
     */
    @GetMapping(value = "/count/active/store/{storeId}")
    public ResponseMessage getActiveOrderCount(@PathVariable String storeId){
        int orderCount = orderService.getActiveOrderCount(storeId);
        return new ResponseMessage(orderCount, MessageResultCode.SUCCESS, null);
    }

    /**
     * 查看新订单的数量(未接订单)
     * @param storeId
     * @return
     */
    @GetMapping(value = "/count/new/store/{storeId}")
    public ResponseMessage getNewOrderCount(@PathVariable String storeId){
        int orderCount = orderService.getNewOrderCount(storeId);
        return new ResponseMessage(orderCount, MessageResultCode.SUCCESS, null);
    }

    /**
     * 查看总订单数
     * @param storeId
     * @return
     */
    @GetMapping(value = "/count/all/store/{storeId}")
    public ResponseMessage getOrderCount(@PathVariable String storeId){
        int orderCount = orderService.getOrderCount(storeId);
        return new ResponseMessage(orderCount, MessageResultCode.SUCCESS, null);
    }

}
