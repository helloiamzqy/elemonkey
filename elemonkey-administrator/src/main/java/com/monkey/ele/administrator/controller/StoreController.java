package com.monkey.ele.administrator.controller;

import com.monkey.ele.administrator.pojo.Store;
import com.monkey.ele.administrator.service.ComplainService;
import com.monkey.ele.administrator.service.StoreService;
import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @Autowired
    private ComplainService complainService;

    /**
     * 更新商家审核状态
     * @param id
     * @param store
     * @return Store
     */
    @PostMapping("{id}")
    public Object updateStoreStatus(@PathVariable("id") String id,@RequestBody Store store){
        return new ResponseMessage(storeService.updateStatus(store),MessageResultCode.SUCCESS,null);
    }

    /**
     * 根据审核状态、获取商家分页
     * @param status
     * @param pageIndex
     * @param pageCount
     * @return Page<Store>
     */
    @GetMapping("status/{status}")
    public Object getStores(@PathVariable("status") Integer status,Integer pageIndex,Integer pageCount){
        return new ResponseMessage(storeService.findStoresPageByStatus(status,pageIndex,pageCount),MessageResultCode.SUCCESS,null);
    }

    /**
     * 根据商家ID、获取商家的投诉集合
     * @param id
     * @return List<Complains>
     */
    @GetMapping("/{id}/complains")
    public Object getComplains(@PathVariable("id") String id){
        return new ResponseMessage(complainService.findComplainsByStoreId(id),MessageResultCode.SUCCESS,null);
    }

    /**
     * 获取各种审核状态的商家数量
     * @return Map<String,Integer>
     */
    @GetMapping("/countStatus")
    public Object getCountAllKindsStatus(){
        return new ResponseMessage(storeService.countStoreStatus(),MessageResultCode.SUCCESS,null);
    }

}
