package com.william.kt.core

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

/**
 * Created by sungang on 2017/11/8.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
class ResultBody(
        var code: String,
        var message: String,
        var result: Any
)