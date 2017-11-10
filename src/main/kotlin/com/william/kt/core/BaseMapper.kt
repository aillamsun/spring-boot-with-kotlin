package com.william.kt.core

import tk.mybatis.mapper.common.ConditionMapper
import tk.mybatis.mapper.common.IdsMapper
import tk.mybatis.mapper.common.Mapper
import tk.mybatis.mapper.common.MySqlMapper
import java.io.Serializable

/**
 * Created by sungang on 2017/11/8.
 */
interface BaseMapper<T : Serializable> : Mapper<T>, MySqlMapper<T>, ConditionMapper<T>, IdsMapper<T> {
}