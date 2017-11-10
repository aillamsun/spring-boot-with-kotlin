package com.william.kt.core.exception

import org.springframework.context.MessageSourceResolvable

/**
 * Created by sungang on 2017/11/10.
 */
abstract class BaseException : Exception, MessageSourceResolvable {


    constructor(message: String) : super(message) {}

    constructor(message: String, cause: Throwable) : super(message, cause) {}


    override fun getArguments(): Array<out Any>? = arrayOf()
    override fun getDefaultMessage(): String? = message
}