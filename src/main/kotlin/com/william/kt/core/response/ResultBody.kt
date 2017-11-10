package com.william.kt.core.response

import com.william.kt.core.enums.GlobalErrorInfoEnum
import java.io.Serializable

/**
 * Created by sungang on 2017/11/10.
 */
class ResultBody : Serializable {

    /**
     * 响应代码
     */
    private var code = GlobalErrorInfoEnum.SUCCESS.code

    /**
     * 响应消息
     */
    private var message: String? = null;

    /**
     * 响应结果
     */
    private var result: Any? = null


    fun setCode(code: String): ResultBody {
        this.code = code
        return this
    }

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String): ResultBody {
        this.message = message
        return this
    }

    fun getResult(): Any? {
        return result
    }

    fun setResult(result: Any): ResultBody {
        this.result = result
        return this
    }

}