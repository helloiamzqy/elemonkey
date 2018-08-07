package com.monkey.ele.customer.service.impl;

import com.monkey.ele.customer.dao.CommentDao;
import com.monkey.ele.customer.pojo.Comment;
import com.monkey.ele.customer.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 8:28 PM 8/2/2018
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Override
    public List<Comment> watchComments(String storeId) {
        return commentDao.findByStoreId(storeId);
    }

    @Override
    public Comment watchOrderComment(String orderId) {
        return commentDao.findByOrderId(orderId);
    }

    @Override
    @Transactional
    public Comment addComment(Comment comment) {
        return commentDao.addComment(comment);
    }
}
