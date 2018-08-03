package com.monkey.ele.customer.controller;


import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.common.util.JsonUtil;
import com.monkey.ele.customer.pojo.Cart;
import com.monkey.ele.customer.service.CartService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "cart")
public class CartController {

    @Autowired
    CartService cartService;

    private static final String CART_COOKIENAME = "cartCokie";
    private static final int CART_COOKIETIME = 48*60*60;

//    @PostMapping("add/")
//    public Object addCart(@CookieValue(value=CART_COOKIENAME,required=false) String cartCokie, HttpServletResponse response, @RequestBody Cart cart) throws Exception {
//        ResponseMessage resMsg = new ResponseMessage();
//        Subject subject = SecurityUtils.getSubject();
//        if(subject.isAuthenticated()){
//
//        }else {
//            String jsonCookie = null;
//            if(!StringUtils.isEmpty(cartCokie)){
//                jsonCookie = URLDecoder.decode(cartCokie, "UTF-8");
//                List<Cart> cartList = JsonUtil.json2list(jsonCookie,Cart.class);
//                int index = -1;
//                for(Cart ca:cartList){
//                    if(ca.getProductId().equals(cart.getProductId())&&ca.getStoreId().equals(cart.getStoreId())){
//                       index = cartList.indexOf(ca);
//                       break;
//                    }
//                }
//                if(index!=-1){
//                    Cart ucart =  cartList.get(index);
//                    ucart.setNum(ucart.getNum()+1);
//                    cartList.remove(index);
//                    cartList.add(ucart);
//                }
//                else {
//                    cart.setNum(1);
//                    cartList.add(cart);
//                }
//                jsonCookie = JsonUtil.obj2json(cartList);
//                System.out.println(jsonCookie);
//            }else {
//                cart.setNum(1);
//                jsonCookie = "["+JsonUtil.obj2json(cart)+"]";
//            }
//            jsonCookie = URLEncoder.encode(jsonCookie, "UTF-8");
//            Cookie cookie = new Cookie(CART_COOKIENAME,jsonCookie);
//            cookie.setMaxAge(CART_COOKIETIME);
//            cookie.setPath("/");
//            response.addCookie(cookie);
//            resMsg.setResultCode(MessageResultCode.SUCCESS);
//        }
//        return resMsg;
//    }


    @GetMapping("/{storeId}/")
    public ResponseMessage getCartByStore(HttpServletRequest request,@PathVariable(value="storeId") String storeId) throws Exception {
        ResponseMessage resMsg = new ResponseMessage();
        String sessionId = request.getSession().getId();
        resMsg.setContent(cartService.getCartByStore(storeId,sessionId));
        resMsg.setResultCode(MessageResultCode.SUCCESS);
        return resMsg;
    }


}
