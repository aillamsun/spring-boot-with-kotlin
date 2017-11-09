package com.william.kt.mapper

import com.william.kt.model.User
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import java.util.*

/**
 * Created by sungang on 2017/11/7.
 */
@Mapper
interface UserMapper {

    @Select("""
        select * from user
    """)
    fun findALl(): List<User>

    @Select("""
        <script>
            select * from user where 1 = 1
             <if test='username != null'>AND USER_NAME like #{username}%</if>
             limit #{pageNo},#{pageSize}
        </script>
    """)
    fun findForPage(pageNo: Integer, pageSize: Integer, username: String): List<User>
}