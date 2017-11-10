package com.william.kt.mapper

import com.william.kt.core.BaseMapper
import com.william.kt.model.User
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import java.util.*

/**
 * Created by sungang on 2017/11/7.
 */
@Mapper
interface UserMapper : BaseMapper<User> {

    @Select("""
        select * from user
    """)
    fun findALl(): List<User>
}