package com.example.appgateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AppGatewayApplication

fun main(args: Array<String>) {
    runApplication<AppGatewayApplication>(*args)
}
