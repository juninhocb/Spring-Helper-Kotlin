package com.example.fluxfunctionalendpoints.car

import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.coRouter

@Component
class CarRoutesConfig(private val carHandler: CarHandler) {

    companion object {
        const val PATH = "/api/v1/car"
    }

    @Bean
    fun carRoutes() = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            GET(PATH, carHandler::getAll)
            GET("$PATH/{id}", carHandler::getById)
            PUT("$PATH/{id}", carHandler::update)
        }
        POST(PATH, carHandler::create)
        DELETE("$PATH/{id}", carHandler::delete)
    }
}