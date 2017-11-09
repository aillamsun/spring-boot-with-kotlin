package com.william.kt.model

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.sql.Timestamp

/**
 * Created by sungang on 2017/11/7.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class User(
        var id: Long,
        var account: String,
        var password: String,
        var createTime: Timestamp


) {

}




