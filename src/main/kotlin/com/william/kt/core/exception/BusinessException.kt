package com.william.kt.core.exception

import org.springframework.context.MessageSourceResolvable

/**
 * 业务异常
 * Created by sungang on 2017/11/10.
 */
abstract class BusinessException : RuntimeException, MessageSourceResolvable {

    constructor(message: String) : super(message) {}

    constructor(message: String, cause: Throwable) : super(message, cause) {}

    override fun getArguments(): Array<out Any>? = arrayOf()
    override fun getDefaultMessage(): String? = message
}