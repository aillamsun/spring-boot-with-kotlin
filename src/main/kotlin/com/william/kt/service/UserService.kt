package com.william.kt.service

import com.william.kt.model.User

/**
 * Created by sungang on 2017/11/7.
 */
interface UserService {

    fun findAll(): List<User>

}