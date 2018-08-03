package com.monkey.ele.customer.dao.impl;

import com.monkey.ele.common.dao.impl.AbstractBaseDao;
import com.monkey.ele.customer.dao.CommentDao;
import com.monkey.ele.customer.pojo.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ Author     ：LILA3
 * @ Date       ：Created in 8:27 PM 8/2/2018
 */
@Repository
public class CommentDaoImpl extends AbstractBaseDao<Comment> implements CommentDao {
    @Override
    public Comment findByOrderId(String orderId) {
        String hql = "From Comment t where t.orderId = ?";
        List<Comment> comments = this.find(hql, orderId);
        if (comments.size() > 0) {
            return comments.get(0);
        }
        return null;
    }

    @Override
    public List<Comment> findByStoreId(String storeId) {
        String hql = "select c From Comment c, Order o, Store s where s.id = o.storeId and o.id = " +
                "c.orderId and o.status = 3 and s.id = ?";
        return this.find(hql, storeId);
    }

    @Override
    public Comment addComment(Comment comment) {
        return this.add(comment);
    }

    @Override
    public Double findStoreRank(String storeId) {
        String hql = "select avg(c.rank) From Comment c, Order o, Store s where s.id = o.storeId and o.id = " +
                "c.orderId and o.status = 3 and s.id = ?";
        Object avg = this.findByAggregate(hql, storeId);
        return (Double) avg;
    }
}
