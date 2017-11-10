package com.william.kt.core.enums

/**
 * Created by sungang on 2017/11/10.
 */
enum class GlobalErrorInfoEnum(var code: String, var message: String) {

    SUCCESS("200", "success"), //成功
    FAIL("400", "fail"), //失败
    UNAUTHORIZED("401", "UNAUTHORIZED"), //未认证（签名错误）
    NOT_FOUND("404", "NOT_FOUND"), //接口不存在
    INTERNAL_SERVER_ERROR("500", "服务器内部异常!"), //服务器内部错误
    SQL_FILTER("500", "包含非法字符!");//服务器内部错误


}