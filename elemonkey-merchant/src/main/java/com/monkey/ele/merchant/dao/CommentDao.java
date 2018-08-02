package com.monkey.ele.merchant.dao;

import com.monkey.ele.common.dao.BaseDao;
import com.monkey.ele.merchant.pojo.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 8:26 PM 8/2/2018
 */
public interface CommentDao extends BaseDao<Comment> {
    public Comment findByOrderId(String orderId);
    public List<Comment> findByStoreId(String storeId);
    public Comment addComment(Comment comment);
}
