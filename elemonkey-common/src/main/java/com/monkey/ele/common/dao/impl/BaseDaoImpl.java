package com.monkey.ele.common.dao.impl;

import com.monkey.ele.common.dao.BaseDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {

    @PersistenceContext
    private EntityManager em;

    private Class<T> clazz = null;

    public BaseDaoImpl(){
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public T add(T t) {
        em.persist(t);
        return t;
    }

    public T update(T t) {
        return em.merge(t);
    }

    public void delete(Serializable id) {
        T t = em.getReference(clazz, id);
        em.remove(t);
    }

    public T load(Serializable id) {
        return em.find(clazz, id);
    }


    public List<T> findAll() {
        return em.createQuery("from "+clazz.getSimpleName()).getResultList();
    }

}
