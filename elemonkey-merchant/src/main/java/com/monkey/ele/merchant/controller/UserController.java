package com.monkey.ele.merchant.controller;

import com.monkey.ele.merchant.pojo.User;
import com.monkey.ele.merchant.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public User regisiter(@RequestBody User user){
        User saveUser = userService.saveUser(user);
        saveUser.setContacts(null);
        saveUser.setOrders(null);
        saveUser.setComplains(null);
        return saveUser;
    }



    @DeleteMapping(value = "{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }

}
