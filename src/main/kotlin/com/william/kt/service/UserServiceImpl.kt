package com.william.kt.service

import com.github.pagehelper.PageHelper
import com.william.kt.core.exception.UserNotFoundException
import com.william.kt.core.service.BaseService
import com.william.kt.mapper.UserMapper
import com.william.kt.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by sungang on 2017/11/7.
 */
@Service
class UserServiceImpl : BaseService<User>(), UserService {

    @Autowired
    private lateinit var userMapper: UserMapper;

    override fun findOne(id: Long): User = userMapper.selectByPrimaryKey(id) ;

    override fun findAll(): List<User> {
        return userMapper.selectAll();
    }

    override fun findAll(pageNo: Int, pageSize: Int): List<User> {
//        PageHelper.startPage(pageNo, pageSize);
        return userMapper.selectAll();
    }
}