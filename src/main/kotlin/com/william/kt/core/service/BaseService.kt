package com.william.kt.core.service

import com.google.common.collect.Maps
import com.william.kt.core.BaseMapper
import org.springframework.beans.factory.annotation.Autowired
import tk.mybatis.mapper.common.Mapper
import tk.mybatis.mapper.entity.Condition
import tk.mybatis.mapper.entity.Example
import java.io.Serializable

/**
 * Created by sungang on 2017/11/10.
 */
open class BaseService<T : Serializable> : IService<T> {

    @Autowired
    private lateinit var mapper: BaseMapper<T>

    fun getMapper(): Mapper<T> {
        return mapper
    }

    override fun select(entity: T): List<T> {
        return mapper?.select(entity)
    }

    override fun selectOne(entity: T): T {
        return mapper?.selectOne(entity)
    }

    override fun selectAll(): List<T> {
        return mapper?.selectAll()
    }

    override fun selectByIds(ids: String): List<T> {
        return mapper?.selectByIds(ids)
    }

    override fun selectByKey(key: Any): T {
        return mapper?.selectByPrimaryKey(key)
    }

    override fun selectCount(t: T): Int {
        return mapper?.selectCount(t)
    }


    override fun selectByExample(example: Example): List<T> {
        return mapper?.selectByExample(example)
    }


    override fun selectCountByExample(example: Example): Int {
        return mapper?.selectCountByExample(example)
    }


    override fun selectByCondition(condition: Condition): List<T> {
        return mapper?.selectByCondition(condition)
    }

    override fun selectCountByCondition(condition: Condition): Int {
        return mapper?.selectCountByExample(condition)
    }

    override fun insert(entity: T): Int {
        return mapper?.insert(entity)
    }


    override fun insertSelective(t: T): Int {
        return mapper?.insertSelective(t)
    }


    override fun insertList(entityList: List<T>): Int {
        return mapper?.insertList(entityList)
    }

    override fun insertUseGeneratedKeys(entity: T): Int {
        return mapper?.insertUseGeneratedKeys(entity)
    }


    override fun updateByPrimaryKey(entity: T): Int {
        return mapper?.updateByPrimaryKey(entity)
    }

    override fun updateByPrimaryKeySelective(entity: T): Int {
        return mapper?.updateByPrimaryKeySelective(entity)
    }


    override fun updateByExample(entity: T, example: Example): Int {
        return mapper?.updateByExample(entity, example)
    }

    override fun updateByExampleSelective(entity: T, example: Example): Int {
        return mapper?.updateByExampleSelective(entity, example)
    }

    override fun updateByCondition(entity: T, condition: Condition): Int {
        return mapper?.updateByCondition(entity, condition)
    }

    override fun updateByConditionSelective(entity: T, condition: Condition): Int {
        return mapper?.updateByConditionSelective(entity, condition)
    }


    override fun delete(entity: T): Int {
        return mapper?.delete(entity)
    }


    override fun deleteByPrimaryKey(key: Any): Int {
        return mapper?.deleteByPrimaryKey(key)
    }

    override fun deleteByIds(ids: String): Int {
        return mapper?.deleteByIds(ids)
    }

    override fun deleteByExample(example: Example): Int {
        return mapper?.deleteByExample(example)
    }

    override fun deleteByCondition(condition: Condition): Int {
        return mapper?.deleteByCondition(condition)
    }


    override fun selectOneByProperty(entityClass: Class<T>, property: String, value: Any): T {
        val list = selectListByProperty(entityClass, property, value)
        if (list.isEmpty()) {
            return null!!
        }
        return list.iterator().next()
    }

    override fun selectListByProperty(entityClass: Class<T>, property: String, value: Any): List<T> {
        val example = Example(entityClass)
        val criteria = example.createCriteria()
        criteria.andEqualTo(property, value)
        return selectByExample(example)
    }

    /**
     * map中都是与的关系
     */
    override fun deleteByMap(entityClass: Class<T>, map: Map<String, Any>): Int {
        val example = makeExample(entityClass, map)
        return this.deleteByExample(example)
    }

    override fun deleteByProperty(entityClass: Class<T>, key: String, `val`: Any): Int {
        val map = Maps.newHashMap<String, Any>()
        map.put(key, `val`)
        return this.deleteByMap(entityClass, map)
    }

    /**
     * map中都是与的关系
     */
    override fun updateByMap(entity: T, entityClass: Class<T>, map: Map<String, Any>): Int {
        val example = makeExample(entityClass, map)
        return this.updateByExample(entity, example)
    }

    override fun updateByProperty(entity: T, entityClass: Class<T>, key: String, `val`: Any): Int {
        val map = Maps.newHashMap<String, Any>()
        map.put(key, `val`)
        return this.updateByMap(entity, entityClass, map)
    }

    override fun updateByMapSelective(entity: T, entityClass: Class<T>, map: Map<String, Any>): Int {
        val example = makeExample(entityClass, map)
        return this.updateByExampleSelective(entity, example)
    }

    override fun updateByPropertySelective(entity: T, entityClass: Class<T>, key: String, `val`: Any): Int {
        val map = Maps.newHashMap<String, Any>()
        map.put(key, `val`)
        return this.updateByMapSelective(entity, entityClass, map)
    }

    override fun selectByMap(entityClass: Class<T>, map: Map<String, Any>): List<T> {
        val example = makeExample(entityClass, map)
        return selectByExample(example)
    }

    override fun selectByProperty(entityClass: Class<T>, key: String, `val`: Any): List<T> {
        val map = Maps.newHashMap<String, Any>()
        map.put(key, `val`)
        return this.selectByMap(entityClass, map)
    }

    fun makeExample(entityClass: Class<T>, map: Map<String, Any>): Example {
        val example = Example(entityClass)
        val criteria = example.createCriteria()
        val iterator = map.keys.iterator()
        while (iterator.hasNext()) {
            val key = iterator.next().toString()
            val `val` = map[key]
            criteria.andEqualTo(key, `val`)
        }
        return example
    }


}