package com.monkey.ele.customer.dao;

import com.monkey.ele.common.dao.BaseDao;
import com.monkey.ele.customer.pojo.Contact;

import java.util.List;

public interface ContactDao extends BaseDao<Contact> {

    List<Contact> findContactByUserId(String userId);



}
