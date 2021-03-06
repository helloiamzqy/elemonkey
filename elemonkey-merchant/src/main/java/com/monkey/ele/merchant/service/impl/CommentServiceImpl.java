package com.monkey.ele.merchant.service.impl;

import com.monkey.ele.merchant.dao.CommentDao;
import com.monkey.ele.merchant.dao.UserDao;
import com.monkey.ele.merchant.pojo.Comment;
import com.monkey.ele.merchant.service.CommentService;
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
