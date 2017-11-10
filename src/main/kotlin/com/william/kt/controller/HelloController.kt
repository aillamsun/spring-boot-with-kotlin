package com.william.kt.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by sungang on 2017/11/7.
 */
@RestController
@Api(value = "1.Hello", description = "Hello")
class HelloController {


    @GetMapping("/hello")
    @ApiOperation(value = "hello", response = String::class)
    fun helloKotlin(): String {
        return "hello Kotlin";
    }
}