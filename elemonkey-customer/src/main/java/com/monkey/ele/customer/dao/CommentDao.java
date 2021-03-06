package com.monkey.ele.customer.dao;


import com.monkey.ele.common.dao.BaseDao;
import com.monkey.ele.customer.pojo.Comment;

import java.util.List;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 8:26 PM 8/2/2018
 */
public interface CommentDao extends BaseDao<Comment> {
    public Comment findByOrderId(String orderId);
    public List<Comment> findByStoreId(String storeId);
    public Comment addComment(Comment comment);
    public Double findStoreRank(String storeId);
}
