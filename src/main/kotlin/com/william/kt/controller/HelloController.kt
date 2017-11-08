package com.william.kt.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by sungang on 2017/11/7.
 */
@RestController
class HelloController{


    @GetMapping("/hello")
    fun helloKotlin(): String {
        return "hello Kotlin";
    }
}