package com.monkey.ele.common.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

    public T add(T t);

    public T update(T t);

    public void delete(Serializable id);

    public T load(Serializable id);

    public List<T> findAll();
}
