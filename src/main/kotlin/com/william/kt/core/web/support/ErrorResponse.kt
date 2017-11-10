package com.william.kt.core.web.support

import com.william.kt.core.response.ResultGenerator
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.MultiValueMap
import java.util.*

/**
 * Created by sungang on 2017/11/10.
 */
data class ErrorResponse(val code: String
                         , val message: String
                         , val timestamp: Date
                         , val bindingErrors: List<String>) {

    constructor(code: String, message: String, bindingErrors: List<String>) : this(code, message, Date(), bindingErrors)
    constructor(code: String, error: String, message: String) : this(code, message, Date(), ArrayList<String>())
    constructor(code: String, message: String) : this(code, message, Date(), ArrayList<String>())

}

class ErrorResponseEntity : ResponseEntity<ErrorResponse> {
    constructor(body: ErrorResponse) : super(body, HttpStatus.INTERNAL_SERVER_ERROR)
    constructor(body: ErrorResponse, headers: MultiValueMap<String, String>) : super(body, headers, HttpStatus.INTERNAL_SERVER_ERROR)

    companion object {

        fun badReqeust(message: String) = ErrorResponseEntity(ErrorResponse(HttpStatus.BAD_REQUEST.toString(), message))
        fun badReqeust(message: String, bindingErrors: List<String>) = ErrorResponseEntity(ErrorResponse(HttpStatus.BAD_REQUEST.toString(), message, bindingErrors))
        fun notFound(message: String) = ErrorResponseEntity(ErrorResponse(HttpStatus.NOT_FOUND.toString(), message))
        fun serverError(message: String) = ErrorResponseEntity(ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), message))

    }

}