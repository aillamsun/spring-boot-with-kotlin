package com.william.kt

import lombok.extern.slf4j.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@Slf4j
open class SpringBootWithKotlinApplication {

}

fun main(args: Array<String>) {
    SpringApplication.run(SpringBootWithKotlinApplication::class.java, *args)

}
