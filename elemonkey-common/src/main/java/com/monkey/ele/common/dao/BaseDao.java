package com.monkey.ele.common.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {


    /**
     * 添加实体类
     * @param t
     * @return
     */
    public T add(T t);

    /**
     * 更新实体类
     * @param t
     * @return
     */
    public T update(T t);

    /**
     * 根据主键ID删除实体类
     * @param id
     */
    public void delete(Serializable id);

    /**
     * 根据主键ID查找单个实体类
     * @param id
     * @return
     */
    public T load(Serializable id);



    /**
     * 查找所有的实体类
     * @return
     */
    public List<T> findAll();


    /**
     * 查找总记录数
     * @return
     */
    public Long count();

    /**
     * 根据JPQL语句查询记录数
     * @param jpql
     * @param obj
     * @return
     */
    public Long count(String jpql,Object... obj);

    /**
     * 根据JPQL语句查询单个实体类
     * @param jpql
     * @param obj（参数可有可无）
     * @return
     */
    public T load(String jpql,Object... obj);

    /**
     * 根据JPQL语句查询集合实体类
     * @param jpql
     * @param obj（参数可有可无）
     * @return
     */
    public List<T> find(String jpql,Object... obj);


    /**
     * 分页
     * @param jpql
     * @param firstIndex
     * @param pageSize
     * @param obj
     * @return
     */
    public List<T> findPage(String jpql,Integer firstIndex, Integer pageSize,Object... obj);


}
