package com.william.kt.core.exception

import org.springframework.context.MessageSourceResolvable

/**
 * 数据查询异常
 * Created by sungang on 2017/11/10.
 */
abstract class DataNotFoundException : BaseException, MessageSourceResolvable {


    constructor(message: String) : super(message) {
    }

    constructor(message: String, cause: Throwable) : super(message, cause) {
    }

    override fun getArguments(): Array<out Any>? = arrayOf()
    override fun getDefaultMessage(): String? = message
}

/**
 * 用户找不到
 */
class UserNotFoundException(val userId: Long) : DataNotFoundException("用户(ID：${userId}) 不存在!") {
    override fun getCodes(): Array<out String> = arrayOf("error.userNotFound")
    override fun getArguments(): Array<out Any> = arrayOf(userId)
}