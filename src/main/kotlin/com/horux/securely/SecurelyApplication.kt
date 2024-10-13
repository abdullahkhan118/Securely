package com.horux.securely

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.horux.securely.**"])
class SecurelyApplication

fun main(args: Array<String>) {
    runApplication<SecurelyApplication>(*args)
}
