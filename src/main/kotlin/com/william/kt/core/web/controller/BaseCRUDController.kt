package com.william.kt.core.web.controller

import org.springframework.validation.BindException
import org.springframework.validation.BindingResult
import org.springframework.validation.beanvalidation.SpringValidatorAdapter
import java.io.Serializable

/**
 * Created by sungang on 2017/11/10.
 */
open class BaseCRUDController<T : Serializable> {

    /**
     * 验证
     */
    fun SpringValidatorAdapter.validateAndThrow(target: Any, bindingResult: BindingResult, vararg validationHints: Any) {
        validate(target, bindingResult)
        validate(target, bindingResult, *validationHints)

        if (bindingResult.hasErrors()) {
            throw BindException(bindingResult)
        }
    }
}