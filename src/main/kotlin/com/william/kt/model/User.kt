package com.william.kt.model

import com.william.kt.core.model.BaseModel
import com.william.kt.core.web.validator.group.DataForm
import io.swagger.annotations.ApiModelProperty
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.sql.Timestamp
import javax.persistence.*
import javax.validation.constraints.NotNull

/**
 * Created by sungang on 2017/11/7.
 */
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Data
class User(


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @ApiModelProperty(hidden = true)
        var id: Long,


        @field:NotNull(message = "用户名不能为空!", groups = arrayOf(DataForm.Write::class, DataForm.Edit::class))
        @ApiModelProperty(value = "账号")
        var account: String? = null,


        @field:NotNull(message = "密码不能为空!", groups = arrayOf(DataForm.Write::class, DataForm.Edit::class))
        @ApiModelProperty(value = "密码")
        var password: String? = null,


        @ApiModelProperty(hidden = true)
        @Column(name = "create_time")
        var createTime: Timestamp? = null

) : BaseModel()




