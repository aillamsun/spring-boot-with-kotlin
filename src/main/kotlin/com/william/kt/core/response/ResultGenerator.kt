package com.william.kt.core.response

import com.william.kt.core.enums.ErrorInfo
import com.william.kt.core.enums.GlobalErrorInfoEnum
import sun.misc.MessageUtils

/**
 * Created by sungang on 2017/11/10.
 */
object ResultGenerator {

    private val DEFAULT_SUCCESS_MESSAGE = "success"

    fun genSuccessResult(): ResultBody {
        return ResultBody()
                .setCode(GlobalErrorInfoEnum.SUCCESS.code)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
    }

    fun genSuccessResult(data: Any): ResultBody {
        return ResultBody()
                .setCode(GlobalErrorInfoEnum.SUCCESS.code)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setResult(data)
    }

    fun genFailResult(errorInfo: ErrorInfo, vararg agrs: Any): ResultBody {
        return ResultBody()
                .setCode(errorInfo.getCode())
                .setMessage(getMessage(errorInfo, *agrs))
    }


    fun genFailResult(code: String, message: String): ResultBody {
        return ResultBody()
                .setCode(code)
                .setMessage(message)
    }

    private fun getMessage(errorInfo: ErrorInfo, vararg agrs: Any): String {
//        var msg = errorInfo.getMessage()
//        if (!StringUtils.isEmpty(errorInfo.getCode()) && null != agrs) {
//            msg = MessageUtils.message(errorInfo.getCode(), agrs)
//        } else {
//            msg = MessageUtils.message(errorInfo.getCode())
//        }

        return "default msg"
    }
}