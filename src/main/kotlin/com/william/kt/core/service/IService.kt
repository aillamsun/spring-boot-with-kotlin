package com.william.kt.core.service

import org.springframework.stereotype.Service
import tk.mybatis.mapper.entity.Condition
import tk.mybatis.mapper.entity.Example
import java.io.Serializable

/**
 * Created by sungang on 2017/11/10.
 */
@Service
interface IService<T : Serializable> {

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号

     * @param entity
     * *
     * @return
     */
    fun selectOne(entity: T): T

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号

     * @param key
     * *
     * @return
     */
    fun selectByKey(key: Any): T

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号

     * @param entity
     * *
     * @return
     */
    fun select(entity: T): List<T>

    /**
     * 查询全部结果，select(null)方法能达到同样的效果

     * @return
     */
    fun selectAll(): List<T>

    /**
     * 根据主键字符串进行查询，类中只有存在一个带有@Id注解的字段
     * ids 如 "1,2,3" 这种形式的字符串

     * @param ids
     * *
     * @return
     */
    fun selectByIds(ids: String): List<T>

    /**
     * 根据实体中的属性查询总数，查询条件使用等号

     * @param t
     * *
     * @return
     */
    fun selectCount(t: T): Int

    /**
     * 根据Example条件进行查询

     * @param example
     * *
     * @return
     */
    fun selectByExample(example: Example): List<T>

    /**
     * 根据Example条件进行查询总数

     * @param example
     * *
     * @return
     */
    fun selectCountByExample(example: Example): Int


    /**
     * 根据Condition条件进行查询

     * @param condition
     * *
     * @return
     */
    fun selectByCondition(condition: Condition): List<T>

    /**
     * 根据Condition条件进行查询总数

     * @return
     */
    fun selectCountByCondition(condition: Condition): Int


    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值

     * @param entity
     * *
     * @return
     */
    fun insert(entity: T): Int

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值

     * @param entity
     * *
     * @return
     */
    fun insertSelective(entity: T): Int

    /**
     * MySQL专用
     * 批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等，另外该接口限制实体包含id属性并且必须为自增列

     * @param entityList
     * *
     * @return
     */
    fun insertList(entityList: List<T>): Int

    /**
     * MySQL专用
     * 插入数据，限制为实体包含id属性并且必须为自增列，实体配置的主键策略无效

     * @param entity
     * *
     * @return
     */
    fun insertUseGeneratedKeys(entity: T): Int


    /**
     * 根据主键更新实体全部字段，null值会被更新

     * @param entity
     * *
     * @return
     */
    fun updateByPrimaryKey(entity: T): Int

    /**
     * 根据主键更新属性不为null的值

     * @param entity
     * *
     * @return
     */
    fun updateByPrimaryKeySelective(entity: T): Int

    /**
     * 根据Example条件更新实体entity包含的全部属性，null值会被更新

     * @param entity
     * *
     * @param example
     * *
     * @return
     */
    fun updateByExample(entity: T, example: Example): Int

    /**
     * 根据Example条件更新实体record包含的不是null的属性值

     * @param entity
     * *
     * @param example
     * *
     * @return
     */
    fun updateByExampleSelective(entity: T, example: Example): Int

    /**
     * 根据Condition条件更新实体entity包含的全部属性，null值会被更新

     * @param entity
     * *
     * @param condition
     * *
     * @return
     */
    fun updateByCondition(entity: T, condition: Condition): Int

    /**
     * 根据Condition条件更新实体entity包含的不是null的属性值

     * @param entity
     * *
     * @param condition
     * *
     * @return
     */
    fun updateByConditionSelective(entity: T, condition: Condition): Int

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号

     * @param entity
     * *
     * @return
     */
    fun delete(entity: T): Int

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性

     * @param key
     * *
     * @return
     */
    fun deleteByPrimaryKey(key: Any): Int

    /**
     * 根据主键字符串进行删除，类中只有存在一个带有@Id注解的字段
     * ids 如 "1,2,3" 这种形式的字符串

     * @param ids
     * *
     * @return
     */
    fun deleteByIds(ids: String): Int

    /**
     * 根据Example条件删除数据

     * @param example
     * *
     * @return
     */
    fun deleteByExample(example: Example): Int

    /**
     * 根据Condition条件

     * @param condition
     * *
     * @return
     */
    fun deleteByCondition(condition: Condition): Int

    /**
     * 通过属性查询一个bean
     * @param entityClass
     * *
     * @param property
     * *
     * @param value
     * *
     * @return
     */
    fun selectOneByProperty(entityClass: Class<T>, property: String, value: Any): T


    fun selectListByProperty(entityClass: Class<T>, property: String, value: Any): List<T>

    fun deleteByMap(entityClass: Class<T>, map: Map<String, Any>): Int

    fun deleteByProperty(entityClass: Class<T>, key: String, `val`: Any): Int

    fun updateByMap(entity: T, entityClass: Class<T>, map: Map<String, Any>): Int

    fun updateByProperty(entity: T, entityClass: Class<T>, key: String, `val`: Any): Int

    fun updateByMapSelective(entity: T, entityClass: Class<T>, map: Map<String, Any>): Int

    fun updateByPropertySelective(entity: T, entityClass: Class<T>, key: String, `val`: Any): Int

    fun selectByMap(entityClass: Class<T>, map: Map<String, Any>): List<T>

    fun selectByProperty(entityClass: Class<T>, key: String, `val`: Any): List<T>
}