package com.monkey.ele.administrator.controller;

import com.monkey.ele.administrator.pojo.Complain;
import com.monkey.ele.administrator.service.ComplainService;
import com.monkey.ele.administrator.websocket.handler.AdministratorHandler;
import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("complains")
public class ComplainController {

    @Autowired
    private ComplainService complainService;

    @Autowired
    AdministratorHandler administratorHandler;

    @GetMapping("/test")
    public Object test(){
        administratorHandler.sendMessageToUser("8a5e9d1d65097546016509c67a420006", new org.springframework.web.socket.TextMessage("收到新的客户投诉信息了"));
        return null;
    }

    /**
     * 更新投诉审核状态
     * @param id
     * @param complain
     * @return
     */
    @PostMapping("{id}")
    public Object updateComplainStatus(@PathVariable("id") String id, @RequestBody Complain complain){
        return new ResponseMessage(complainService.updateComplain(complain),MessageResultCode.SUCCESS,null);
    }

    /**
     * 根据不同审核状态、获取投诉分页
     * @param status
     * @param pageIndex
     * @param pageCount
     * @return
     */
    @GetMapping("status/{status}")
    public Object getComplains(@PathVariable("status") Integer status,Integer pageIndex,Integer pageCount){
        return new ResponseMessage(complainService.findComplainsPageByStatus(status,pageIndex,pageCount),MessageResultCode.SUCCESS,null);
    }


    /**
     * 获取各种审核状态的投诉数量
     * @return Map<String,Integer>
     */
    @GetMapping("/countStatus")
    public Object getCountAllKindsStatus(){
        return new ResponseMessage(complainService.countComplainStatus(),MessageResultCode.SUCCESS,null);
    }


}
