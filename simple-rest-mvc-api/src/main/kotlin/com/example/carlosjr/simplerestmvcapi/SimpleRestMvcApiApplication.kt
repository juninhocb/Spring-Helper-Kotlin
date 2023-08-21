package com.example.carlosjr.simplerestmvcapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SimpleRestMvcApiApplication

fun main(args: Array<String>) {
    runApplication<SimpleRestMvcApiApplication>(*args)
}
