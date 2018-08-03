package com.monkey.ele.service.impl;

import com.monkey.ele.common.util.JsonUtil;
import com.monkey.ele.common.util.Md5Utils;
import com.monkey.ele.merchant.pojo.Identity;
import com.monkey.ele.merchant.pojo.User;
import com.monkey.ele.merchant.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImplTest {

    private static ApplicationContext context;
    private UserServiceImpl service;


    @BeforeClass
    public static void init(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Before
    public void initService(){
        service = context.getBean(UserServiceImpl.class);
    }

    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("addUser1");
        user.setPassword(Md5Utils.md5Password("123456"));
        user.setType(User.UserType.MERCHANT);
        Identity identity = new Identity();
        identity.setIdCardNumber("4413021999545452232");
        identity.setIdCardPic("/img/xxxxx.png");
        identity.setName("identityName");
        user.setIdentity(identity);
        service.saveUser(user);
    }


    @Test
    public void testDeleteUser(){
        service.deleteUser("8a5e9d4464f898eb0164f898f1eb0000");
    }


    @Test
    public void testLoadUser() throws Exception {
        User user = service.loadUser("8a5e9d4464f8b61e0164f8b624fe0000");
        user.setComplains(null);
        user.setContacts(null);
        user.setOrders(null);
        System.out.println(JsonUtil.obj2json(user));
    }

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId("8a5e9d4464f8bad20164f8bad9810000");
        user.setUsername("addUser2");
        Identity identity = new Identity();
        identity.setId("8a5e9d4464f8bad20164f8bad9880001");
        identity.setName("aaaaa");
        user.setIdentity(identity);
        service.updateUser(user);
    }



}
