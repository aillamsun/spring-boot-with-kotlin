package com.william.kt.service

import com.william.kt.model.User

/**
 * Created by sungang on 2017/11/7.
 */
interface UserService {

    fun findAll(): List<User>

    fun findAll(pageNo: Integer,pageSize: Integer, username: String): List<User>
}