package com.monkey.ele.common.dao.impl;

import com.monkey.ele.common.dao.BaseDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractBaseDao<T> implements BaseDao<T> {

    @PersistenceContext
    private EntityManager em;

    private Class<T> clazz = null;

    public AbstractBaseDao(){
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
    }


    @Override
    public T add(T t) {
        em.persist(t);
        return t;
    }

    @Override
    public T update(T t) {
        return em.merge(t);
    }


    @Override
    public void delete(Serializable id) {
        T t = em.getReference(clazz, id);
        em.remove(t);
    }

    @Override
    public T load(Serializable id) {
        return em.find(clazz, id);
    }

    @Override
    public List<T> findAll() {
        return em.createQuery("from "+clazz.getSimpleName()).getResultList();
    }

    @Override
    public int executeUpdate(String jpql, Object... obj) {
        Query query = em.createQuery(jpql);
        if(obj.length > 0){
            for (int i = 0; i < obj.length; i++) {
                query.setParameter((i+1),obj[i]);
            }
        }
        return query.executeUpdate();
    }


    @Override
    public Long count() {
        return (Long) em.createQuery("select count(*) from "+clazz.getSimpleName()).getSingleResult();
    }

    @Override
    public Long count(String jpql,Object... obj) {
        Query query = em.createQuery(jpql);
        if(obj.length > 0){
            for (int i = 0; i < obj.length; i++) {
                query.setParameter((i+1),obj[i]);
            }
        }
        return (Long) query.getSingleResult();
    }

    @Override
    public T load(String jpql, Object... obj) {
        Query query = em.createQuery(jpql);
        if(obj.length > 0){
            for (int i = 0; i < obj.length; i++) {
                query.setParameter((i+1),obj[i]);
            }
        }
        return (T) query.getSingleResult();
    }

    @Override
    public List<T> find(String jpql, Object... obj) {
        Query query = em.createQuery(jpql);
        if(obj.length > 0){
            for (int i = 0; i < obj.length; i++) {
                query.setParameter((i+1),obj[i]);
            }
        }
        return query.getResultList();
    }

    @Override
    public List<T> findPage(Integer firstIndex, Integer maxResults) {
        return em.createQuery("from "+clazz.getSimpleName()).setFirstResult(firstIndex).setMaxResults(maxResults).getResultList();
    }

    @Override
    public List<T> findPage(Integer firstIndex, Integer maxResults,String jpql,Object... obj) {
        Query query = em.createQuery(jpql);
        if(obj.length > 0){
            for (int i = 0; i < obj.length; i++) {
                query.setParameter((i+1),obj[i]);
            }
        }
        query.setFirstResult(firstIndex).setMaxResults(maxResults);
        return query.getResultList();
    }


}
