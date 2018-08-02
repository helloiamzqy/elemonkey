package com.monkey.ele.customer.service.impl;

import com.monkey.ele.customer.pojo.Contact;
import com.monkey.ele.customer.service.ContectService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class ContectServiceImplTest {


    private static ApplicationContext context;


    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }



    @Test
    public void findContactByUser() {
        ContectService contectService = context.getBean(ContectService.class);
        List<Contact> contacts = contectService.findContactByUser("8a5e9d4464f8bad20164f8bad9810000");
        System.out.println(contacts.size());
        Assert.assertTrue(contacts.size()>0);
    }

    @Test
    public void addContact() {
        ContectService contectService = context.getBean(ContectService.class);
        Contact contact = new Contact();
        contact.setAddress("testContact3");
        contact.setPhone("13701761289");
        contact.setUserId("8a5e9d4464f9820e0164f9823cc20000");
        Contact newContact = contectService.addContact(contact);
        Assert.assertTrue(newContact.getId()!=null);
    }


    @Test
    public void delContact() {
        ContectService contectService = context.getBean(ContectService.class);
        Assert.assertTrue(contectService.delContact("8a5e9d4464f9820e0164f9823c880000","23qwdd89yrnuf"));
    }

    @Test
    public void updateContact() {
        ContectService contectService = context.getBean(ContectService.class);
        Contact contact = new Contact();
        contact.setId("23qwdd89yrnuf");
        contact.setAddress("testContact");
        contact.setPhone("88888888");
        contact.setUserId("8a5e9d4464f8bad20164f8bad9810000");
        Contact newContact = contectService.updateContact(contact);
        Assert.assertTrue(newContact.getPhone().equals(contact.getPhone()));
    }


}