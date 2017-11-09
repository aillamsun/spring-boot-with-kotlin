package com.william.kt.service

import com.william.kt.mapper.UserMapper
import com.william.kt.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by sungang on 2017/11/7.
 */
@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var userMapper: UserMapper;

    override fun findAll(): List<User> {
        return userMapper.findALl();
    }

    override fun findAll(pageNo: Integer, pageSize: Integer, username: String): List<User> {
        return userMapper.findForPage(pageNo,pageSize,username);
    }
}