package com.william.kt.controller

import com.william.kt.core.response.ResultBody
import com.william.kt.core.response.ResultGenerator
import com.william.kt.core.web.controller.BaseCRUDController
import com.william.kt.core.web.validator.group.DataForm
import com.william.kt.model.User
import com.william.kt.service.UserServiceImpl
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.BindException
import org.springframework.validation.BindingResult
import org.springframework.validation.beanvalidation.SpringValidatorAdapter
import org.springframework.web.bind.annotation.*
import java.sql.Timestamp
import javax.validation.Valid

/**
 * Created by sungang on 2017/11/7.
 */
@RestController
@RequestMapping("user")
@Api(value = "1.用户", description = "用户")
class UserController : BaseCRUDController<User>() {


    @Autowired
    private lateinit var userService: UserServiceImpl;
    @Autowired
    private lateinit var validator: SpringValidatorAdapter;


    @ApiOperation(value = "添加用户", response = ResultBody::class)
    @PostMapping
    fun addUser(@RequestBody user: User, bindingResult: BindingResult): ResultBody {
        /**
         * 验证数据
         */
        validator.validateAndThrow(user, bindingResult, DataForm.Write::class.java)

        userService.insert(user);
        return ResultGenerator.genSuccessResult();
    }

    /**
     *
     */
    @GetMapping
    @ApiOperation(value = "获取所有用户", response = User::class)
    fun getAll(): ResultBody {
        var users: List<User> = userService.findAll();
        return ResultGenerator.genSuccessResult(users);
    }


    @GetMapping("for-page")
    @ApiOperation(value = "分页获取用户", response = User::class)
    fun getForPage(
            username: String,
            @RequestParam pageNo: Integer,
            @RequestParam pageSize: Integer
    ): ResultBody {
        var users: List<User> = userService.findAll();
        return ResultGenerator.genSuccessResult(users);
    }

    @ApiOperation(value = "删除用户", response = ResultBody::class)
    @DeleteMapping("{id}")
    fun delUser(
            @PathVariable(name = "id") id: Long
    ): ResultBody {
        userService.deleteByPrimaryKey(id);
        return ResultGenerator.genSuccessResult();
    }
}