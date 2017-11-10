# spring-boot-with-kotlin
spring-boot kotlin example


### 技术介绍

    > * 使用spring boot2.0.0M5 ，Spring5.0.0 通用 Mybatis PageHeper
    
    > * 使用 java8 + Kotlin 
    
### 基本功能
 
    > * 1 集成mybatis 通用mapper 和 分页
    > * 2 封装统一异常处理
    > * 3 全局分组参数验证
    > * 4 全局接口返回格式统一封装
    
    

## 1 异常部分

### 自定义异常
```java
/**
 * 数据查询异常
 * Created by sungang on 2017/11/10.
 */
abstract class DataNotFoundException : BaseException, MessageSourceResolvable {


    constructor(message: String) : super(message) {
    }

    constructor(message: String, cause: Throwable) : super(message, cause) {
    }

    override fun getArguments(): Array<out Any>? = arrayOf()
    override fun getDefaultMessage(): String? = message
}

/**
 * 用户找不到
 */
class UserNotFoundException(val userId: Long) : DataNotFoundException("用户(ID：${userId}) 不存在!") {
    override fun getCodes(): Array<out String> = arrayOf("error.userNotFound")
    override fun getArguments(): Array<out Any> = arrayOf(userId)
}
```
    
### 统一异常处理
```java
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
```

    
## 2 参数验证部分


### 验证规则
```java
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
```

### 验证案例
```java
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
```


### 分组定义
```java
/**
 *
 * 验证分组
 * Created by sungang on 2017/11/10.
 */
class DataForm() {
    interface Write

    interface Edit
}
```


## 3 项目启动

> * resources/spring-boot-kotlin.sql

> * com.william.kt.SpringBootWithKotlinApplication
 
> * 访问http://localhost:7100/swagger-ui.html