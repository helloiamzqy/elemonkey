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
//    public T update(T t) {
//        Map<String,Object> map = this.getFieldValueMap(t);
//        T tt = em.getReference(clazz,map.get("id"));
//        //遍历这个map对象
//        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
//        for (Map.Entry<String, Object> entry : entrySet){
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            if(value!=null ){
//                try {
//                    Method m = clazz.getClass().getMethod(getSetterMethodName(key));
//                    System.out.println("mmmmmmmm:"+m);
//                } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println(key + ">>>>>>>" + value);
//        }
//        return t;
//    }

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
                query.setParameter(i+1,obj[i]);
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
                query.setParameter(i+1,obj[i]);
            }
        }
        return (Long) query.getSingleResult();
    }

    @Override
    public T load(String jpql, Object... obj) {
        Query query = em.createQuery(jpql);
        if(obj.length > 0){
            for (int i = 0; i < obj.length; i++) {
                query.setParameter(i+1,obj[i]);
            }
        }
        return (T) query.getSingleResult();
    }

    @Override
    public List<T> find(String jpql, Object... obj) {
        Query query = em.createQuery(jpql);
        if(obj.length > 0){
            for (int i = 0; i < obj.length; i++) {
                query.setParameter(i+1,obj[i]);
            }
        }
        return query.getResultList();
    }

    @Override
    public List<T> findPage(Integer firstIndex, Integer pageSize) {
        return em.createQuery("from "+clazz.getSimpleName()).setFirstResult(firstIndex).setMaxResults(pageSize).getResultList();
    }

    @Override
    public List<T> findPage(String jpql,Integer firstIndex, Integer pageSize,Object... obj) {
        Query query = em.createQuery(jpql);
        if(obj.length > 0){
            for (int i = 0; i < obj.length; i++) {
                query.setParameter(i+1,obj[i]);
            }
        }
        query.setFirstResult(firstIndex).setMaxResults(pageSize);
        return query.getResultList();
    }


//    /**
//     * 获取指定实例的所有属性名及对应值的Map实例
//     * @param entity   实例
//     * @return 字段名及对应值的Map实例
//     */
//    protected Map<String, Object> getFieldValueMap(T entity) {
//        // key是属性名，value是对应值
//        Map<String, Object> fieldValueMap = new HashMap<String, Object>();
//
//        // 获取当前加载的实体类中所有属性（字段）
//        Field[] fields = this.clazz.getDeclaredFields();
//
//        for (int i = 0; i < fields.length; i++) {
//            Field f = fields[i];
//            String key = f.getName();// 属性名
//            Object value = null;//属性值
//            if (! "serialVersionUID".equals(key)) {// 忽略序列化版本ID号
//                f.setAccessible(true);// 取消Java语言访问检查
//                try {
//                    value =f.get(entity);
//                } catch (IllegalArgumentException e) {
//                    e.printStackTrace();
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//                fieldValueMap.put(key, value);
//            }
//        }
//        return fieldValueMap;
//    }
//
//    /**
//     * 根据属性名称获取对应的setter方法名称
//     * @param property
//     * @return
//     */
//    public String getSetterMethodName(String property) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(property);
//        if (Character.isLowerCase(sb.charAt(0))) {
//            if (sb.length() == 1 || !Character.isUpperCase(sb.charAt(1))) {
//                sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
//            }
//        }
//        sb.insert(0, "set");
//        return sb.toString();
//    }
}
