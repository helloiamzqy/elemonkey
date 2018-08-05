package com.monkey.ele.customer.service;

import com.monkey.ele.customer.pojo.Comment;
import java.util.List;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 8:28 PM 8/2/2018
 */
public interface CommentService {
    public List<Comment> watchComments(String storeId);
    public Comment watchOrderComment(String orderId);
    public Comment addComment(Comment comment);
}
