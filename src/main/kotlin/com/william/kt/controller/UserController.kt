package com.william.kt.controller

import com.william.kt.core.ResultBody
import com.william.kt.model.User
import com.william.kt.service.UserService
import com.william.kt.service.UserServiceImpl
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by sungang on 2017/11/7.
 */
@RestController
@RequestMapping("user")
@Api(value = "1.用户", description = "用户")
class UserController {
    @Autowired
    private lateinit var userService: UserServiceImpl;

    /**
     *
     */
    @GetMapping
    @ApiOperation(value = "获取所有用户", response = User::class)
    fun getAll(): List<User> {
        var users: List<User> = userService.findAll();
        return users;
    }


    @GetMapping("for-page")
    @ApiOperation(value = "分页获取用户", response = User::class)
    fun getForPage(
            username: String,
            @RequestParam pageNo: Integer,
            @RequestParam pageSize: Integer
    ): List<User> {
        var users: List<User> = userService.findAll();
        return users;
    }
}