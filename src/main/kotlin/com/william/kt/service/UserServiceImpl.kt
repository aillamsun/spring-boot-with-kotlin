package com.william.kt.service

import com.william.kt.mapper.UserMapper
import com.william.kt.model.User
import org.springframework.stereotype.Service

/**
 * Created by sungang on 2017/11/7.
 */
@Service
class UserServiceImpl : UserService {

    private lateinit var userMapper: UserMapper;

    override fun findAll(): List<User> {
        return userMapper.findALl();
    }
}