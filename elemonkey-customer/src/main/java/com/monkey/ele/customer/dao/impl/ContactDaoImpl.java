package com.monkey.ele.customer.dao.impl;

import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import com.monkey.ele.customer.dao.ContactDao;
import com.monkey.ele.customer.pojo.Contact;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactDaoImpl extends AbstractBaseDao<Contact> implements ContactDao {


    @Override
    public List<Contact> findContactByUserId(String userId) {
         String findByUserId = "From Contact c where c.userId=?";
         return this.find(findByUserId,userId);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return null;
    }


}
