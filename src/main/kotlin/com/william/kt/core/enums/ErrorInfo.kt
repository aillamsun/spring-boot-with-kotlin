package com.william.kt.core.enums

/**
 * 错误码接口
 * Created by sungang on 2017/11/10.
 */
interface ErrorInfo {
    fun getCode(): String

    fun getMessage(): String

    fun setMessage(message: String)
}