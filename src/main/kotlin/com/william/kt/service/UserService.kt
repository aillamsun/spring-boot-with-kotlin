package com.william.kt.service

import com.william.kt.core.service.IService
import com.william.kt.model.User

/**
 * Created by sungang on 2017/11/7.
 */
interface UserService : IService<User> {

    fun findOne(id: Long): User

    fun findAll(): List<User>

    fun findAll(pageNo: Int, pageSize: Int): List<User>
}