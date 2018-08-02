package com.monkey.ele.merchant.controller;

import com.monkey.ele.merchant.pojo.Product;
import com.monkey.ele.merchant.pojo.User;
import com.monkey.ele.merchant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @DeleteMapping(value = "{id}")
    public void deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
    }


    @PutMapping
    public Product updateProduct(Product product){
        return productService.updateProduct(product);
    }


    @GetMapping
    public List<Product> findAllProducts(){
        return productService.findAllProducts();
    }

    @GetMapping(value = "{id}")
    public Product loadProduct(@PathVariable String id){
        return productService.loadProduct(id);
    }


}
