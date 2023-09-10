package com.example.fluxfunctionalendpoints.car

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CarService {
    fun getById(id: Mono<Long>) : Mono<CarDto>
    fun getAll() : Flux<CarDto>
    fun create(dto: Mono<CarDto>) : Mono<Long>
    fun update(id: Mono<Long>, dto: Mono<CarDto>) : Mono<Void>
    fun delete(id: Mono<Long>)
}