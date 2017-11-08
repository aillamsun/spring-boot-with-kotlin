package com.william.kt.controller

import com.william.kt.model.User
import com.william.kt.service.UserService
import com.william.kt.service.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by sungang on 2017/11/7.
 */
@RestController
@RequestMapping("user")
class UserController {

    @Autowired
    private lateinit var userService: UserServiceImpl;

    /**
     *
     */
    @GetMapping
    fun getAll(): List<User> {
        var users: List<User> = userService.findAll();
        return users;
    }
}