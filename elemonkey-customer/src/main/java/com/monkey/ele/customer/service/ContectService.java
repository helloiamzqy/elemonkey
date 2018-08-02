package com.monkey.ele.customer.service;

import com.monkey.ele.customer.pojo.Contact;

import java.util.List;

public interface ContectService {

    public List<Contact> findContactByUser(String userId);

    public Contact addContact(Contact contact);

    public boolean delContact(String contactId);

    public Contact updateContact(Contact contact);

}
