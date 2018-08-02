package com.monkey.ele.customer.service.impl;

import com.monkey.ele.customer.dao.ContactDao;
import com.monkey.ele.customer.pojo.Contact;
import com.monkey.ele.customer.service.ContectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ContectServiceImpl implements ContectService {

    @Autowired
    ContactDao contactDao;

    @Transactional
    @Override
    public List<Contact> findContactByUser(String userId) {
        return contactDao.findContactByUserId(userId);
    }

    @Transactional
    @Override
    public Contact addContact(Contact contact) {
        return contactDao.add(contact);
    }


    @Transactional
    @Override
    public boolean delContact(String userId,String contactId) {
        List<Contact> contactList = contactDao.findContactByUserId(userId);
        for(Contact contact:contactList) {
            if (contact.getId().equals(contactId)) {
                contactDao.delete(contactId);
                return true;
            }
        }
        return false;
    }


    @Transactional
    @Override
    public Contact updateContact(Contact contact) {
        return contactDao.update(contact);
    }


}
