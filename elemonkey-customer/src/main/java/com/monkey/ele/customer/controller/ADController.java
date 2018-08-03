package com.monkey.ele.customer.controller;


import com.monkey.ele.common.pojo.ResponseMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ad")
public class ADController {

    @GetMapping("/")
    public Object getAD(){
        ResponseMessage resMsg = new ResponseMessage();
//        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target("http://localhost:3000/customers");
//        String s=target
//                .path("2")
////				.queryParam("page", "1")
//                .request()
//                .get()
//                .readEntity(String.class);
//        System.out.println(s);
//        client.close();
        return resMsg;
    }

}
