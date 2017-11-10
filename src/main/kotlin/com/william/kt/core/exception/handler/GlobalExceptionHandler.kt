package com.william.kt.core.exception.handler

import com.william.kt.core.exception.BaseException
import com.william.kt.core.exception.DataNotFoundException
import com.william.kt.core.web.support.ErrorResponseEntity
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.validation.BindingResult
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.*

import com.william.kt.core.web.support.ErrorResponseEntity.Companion.badReqeust
import com.william.kt.core.web.support.ErrorResponseEntity.Companion.notFound
import com.william.kt.core.web.support.ErrorResponseEntity.Companion.serverError
import org.springframework.validation.BindException

/**
 *
 * 统一异常处理
 * Created by sungang on 2017/11/10.
 */
@Slf4j
@RestControllerAdvice
class GlobalExceptionHandler @Autowired constructor(var messageSource: MessageSource) {

    /**
     * 全局异常
     */
    @ExceptionHandler(BaseException::class)
    fun baseException(exception: BaseException, locale: Locale) =
            serverError(messageSource.getMessage(exception, locale))

    /**
     * 数据资源找不到异常
     */
    @ExceptionHandler(DataNotFoundException::class)
    fun resourceNotFoundException(exception: DataNotFoundException, locale: Locale) =
            notFound(messageSource.getMessage(exception, locale))

    /**
     * 参数验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidException(exception: MethodArgumentNotValidException, locale: Locale) =
            badReqeust("参数不正确.", mapBindingResult(exception.bindingResult, locale));

    @ExceptionHandler(BindException::class)
    fun bindException(exception: BindException, locale: Locale) =
            badReqeust("参数不正确.", mapBindingResult(exception.bindingResult, locale));


    fun mapBindingResult(bindingResult: BindingResult, locale: Locale) =
            bindingResult.allErrors.map { messageSource.getMessage(it, locale) }
}