package com.william.kt.mapper

import com.william.kt.model.User

/**
 * Created by sungang on 2017/11/7.
 */
interface UserMapper {

    fun findALl(): List<User>
}