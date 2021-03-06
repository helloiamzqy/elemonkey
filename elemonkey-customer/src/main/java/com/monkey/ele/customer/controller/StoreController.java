package com.monkey.ele.customer.controller;

import com.auth0.jwt.internal.org.apache.commons.lang3.time.DateUtils;
import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.Page;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.common.util.DateFormat;
import com.monkey.ele.customer.pojo.Store;
import com.monkey.ele.customer.service.ProductService;
import com.monkey.ele.customer.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("store")
public class StoreController {


    @Autowired
    ProductService productService;

    @Autowired private StoreService storeService;


    @RequestMapping
    public ResponseMessage getPassStore(Integer pageNum, Integer maxResults) {
        ResponseMessage resMsg = new ResponseMessage();
        Page<Store> storePage = (pageNum != null && maxResults != null && pageNum!=0) ?
                storeService.findPassStorePage((pageNum-1)*maxResults, maxResults):storeService.findPassStore();
        for (Store store: storePage.getItems()) {
            store.setOpening(DateFormat.compareOpen(store.getStoreInformation().getOpen(),store.getStoreInformation().getClose()));
            store.setOrders(null);
            store.setProducts(null);
            store.setUser(null);
            Double rank = storeService.watchStoreRank(store.getId());
            store.setRank(rank == null ? 0 : rank);
        }
        resMsg.setContent(storePage);
        resMsg.setResultCode(MessageResultCode.SUCCESS);
        return resMsg;
    }

    @GetMapping("/{storeId}/prod")
    public ResponseMessage getStoreProduct(@PathVariable(value = "storeId") String storeId, Integer pageNum, Integer maxResults) {
        ResponseMessage resMsg = new ResponseMessage();
        resMsg.setContent((pageNum != null && maxResults != null && pageNum!=0) ?
                productService.getAllProductByStorePage(storeId,(pageNum-1)*maxResults , maxResults):productService.getAllProductByStore(storeId));
        resMsg.setResultCode(MessageResultCode.SUCCESS);
        return resMsg;
    }

    @GetMapping("/{storeId}/rank")
    public ResponseMessage getStoreRank(@PathVariable("storeId") String storeId) {
        Double rank = storeService.watchStoreRank(storeId);
        return new ResponseMessage(rank, MessageResultCode.SUCCESS, null);
    }

    @GetMapping("/{storeId}")
    public ResponseMessage getSingleStore(@PathVariable("storeId") String storeId) {
        Store store = storeService.getSingleStore(storeId);
        store.setOrders(null);
        store.setProducts(null);
        store.setUser(null);
        Double rank = storeService.watchStoreRank(store.getId());
        store.setRank(rank == null ? 0 : rank);
        return new ResponseMessage(store, MessageResultCode.SUCCESS, null);
    }

    @RequestMapping("/hot/{limit}")
    public ResponseMessage test(@PathVariable Integer limit) {
        List<Store> stores = storeService.findHotStoreLimit(limit);
        for (Store store: stores) {
            Double rank = storeService.watchStoreRank(store.getId());
            store.setOpening(DateFormat.compareOpen(store.getStoreInformation().getOpen(),store.getStoreInformation().getClose()));
            store.setRank(rank == null ? 0 : rank);
            store.setOrders(null);
            store.setProducts(null);
            store.setUser(null);
        }
        return new ResponseMessage(stores, MessageResultCode.SUCCESS, "查询成功");
    }

}
