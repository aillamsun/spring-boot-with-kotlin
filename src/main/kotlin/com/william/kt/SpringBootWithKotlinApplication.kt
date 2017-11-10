package com.william.kt

import com.didispace.swagger.EnableSwagger2Doc
import lombok.extern.slf4j.Slf4j
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@Slf4j
@MapperScan("com.william.kt.mapper")
@ComponentScan("com.william.kt")
@EnableSwagger2Doc
open class SpringBootWithKotlinApplication {

}
fun main(args: Array<String>) {
    SpringApplication.run(SpringBootWithKotlinApplication::class.java, *args)

}
