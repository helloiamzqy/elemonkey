package com.monkey.ele.customer.controller;


import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.customer.pojo.Cart;
import com.monkey.ele.customer.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "cart")
public class CartController {

    @Autowired
    CartService cartService;

    private static final String CART_COOKIENAME = "cartCokie";
    private static final int CART_COOKIETIME = 48*60*60;



    @GetMapping("/{storeId}/")
    public ResponseMessage getCartByStore(HttpServletRequest request,@PathVariable(value="storeId") String storeId){
        ResponseMessage resMsg = new ResponseMessage();
        String sessionId = request.getSession().getId();
        resMsg.setContent(cartService.getCartByStore(sessionId,storeId));
        resMsg.setResultCode(MessageResultCode.SUCCESS);
        return resMsg;
    }

    @PostMapping("/{storeId}/add/")
    public Object addCart(HttpServletRequest request, @RequestBody Cart cart,@PathVariable(value="storeId") String storeId){
        ResponseMessage resMsg = new ResponseMessage();
        String sessionId = request.getSession().getId();
        cartService.addCart(sessionId,storeId,cart);
        resMsg.setContent(cartService.getCartByStore(sessionId,storeId));
        resMsg.setResultCode(MessageResultCode.SUCCESS);
        return resMsg;
    }


    @PostMapping("/{storeId}/empty/")
    public Object emptyCart(HttpServletRequest request,@PathVariable(value="storeId") String storeId){
        ResponseMessage resMsg = new ResponseMessage();
        String sessionId = request.getSession().getId();
        cartService.emptyCart(sessionId,storeId);
        resMsg.setResultCode(MessageResultCode.SUCCESS);
        return resMsg;
    }

    @PostMapping("/{storeId}/reduce/")
    public Object reduceCart(HttpServletRequest request,@RequestBody Cart cart,@PathVariable(value="storeId") String storeId){
        ResponseMessage resMsg = new ResponseMessage();
        String sessionId = request.getSession().getId();
        boolean result = cartService.reduceCart(sessionId,storeId,cart);
        resMsg.setContent(result?cartService.getCartByStore(sessionId,storeId):null);
        resMsg.setResultCode(result?MessageResultCode.SUCCESS:MessageResultCode.ERROR);
        return resMsg;
    }

}
