package com.monkey.ele.merchant.controller;

import com.monkey.ele.common.pojo.Message;
import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.merchant.pojo.Product;
import com.monkey.ele.merchant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    /**
     * 添加商品
     * @param product
     * @return
     */
    @PostMapping
    public ResponseMessage addProduct(@RequestBody Product product){
        Product saveProduct = productService.saveProduct(product);
        ResponseMessage message = null;
        if(saveProduct == null){
            message = new ResponseMessage(null,MessageResultCode.ERROR,Message.MSG_ADD_ERROR);
        }else{
            message = new ResponseMessage(saveProduct,MessageResultCode.SUCCESS,Message.MSG_ADD_SUCCESS);
        }
        return message;
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @DeleteMapping(value = "{id}")
    public ResponseMessage deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
        return new ResponseMessage(null,MessageResultCode.SUCCESS,Message.MSG_DELETE_SUCCESS);
    }


    /**
     * 修改商品
     * @param product
     * @return
     */
    @PutMapping
    public ResponseMessage updateProduct(@RequestBody Product product){
        Product updateProduct = productService.updateProduct(product);
        ResponseMessage message = null;
        if(updateProduct == null){
            message = new ResponseMessage(null,MessageResultCode.ERROR,Message.MSG_UPDATE_ERROR);
        }else{
            message = new ResponseMessage(updateProduct,MessageResultCode.SUCCESS,Message.MSG_UPDATE_SUCCESS);
        }
        return message;
    }


    /**
     * 查询所有的商品
     * @return
     */
    @GetMapping
    public ResponseMessage findAllProducts(){
        return new ResponseMessage(productService.findAllProducts(),MessageResultCode.SUCCESS,null);
    }

    /**
     * 查询指定商品
     * @param id
     * @return
     */
    @GetMapping(value = "{id}")
    public ResponseMessage loadProduct(@PathVariable String id){
        return new ResponseMessage(productService.loadProduct(id),MessageResultCode.SUCCESS,null);
    }


    /**
     * 查询商店的所有商品
     * @param id
     * @return
     */
    @GetMapping(value = "/store/{id}")
    public ResponseMessage findProductByStore(@PathVariable String id){
        return new ResponseMessage(productService.findByStoreId(id),MessageResultCode.SUCCESS,null);
    }



}
