package com.monkey.ele.customer.controller;


import com.monkey.ele.common.pojo.MessageResultCode;
import com.monkey.ele.common.pojo.ResponseMessage;
import com.monkey.ele.customer.pojo.Advertisement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping("/ad")
public class ADController {

    private String AD_URL = "http://10.222.29.161:8989/ads";

    @GetMapping("/")
    public Object getAD(){
        ResponseMessage resMsg = new ResponseMessage();
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(AD_URL);
        List<Advertisement> list=target
                .request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(new GenericType<List<Advertisement>>(){});
        resMsg.setContent(list);
        resMsg.setResultCode(MessageResultCode.SUCCESS);
        return resMsg;
    }

}
