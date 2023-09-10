package com.example.fluxfunctionalendpoints.car

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.withContext
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono


@Component
class CarHandler(private val service: CarService) {

    suspend fun getById(request: ServerRequest) : ServerResponse {
        val id = request.pathVariable("id").toLong()
        return service.getById(Mono.just(id)).flatMap {
            ok().contentType(MediaType.APPLICATION_JSON).bodyValue(it)
        }.awaitSingle()
    }

    suspend fun getAll(request: ServerRequest): ServerResponse {
        val cars = service.getAll().collectList()
        return withContext(Dispatchers.IO) {
            ok().contentType(MediaType.APPLICATION_JSON).body(cars, List::class.java).awaitSingle()
        }
    }

    suspend fun create(request: ServerRequest) : ServerResponse {
        return service.create(request.bodyToMono(CarDto::class.java)).flatMap {
            val uri = UriComponentsBuilder
                .fromUriString("http://localhost:8080/${CarRoutesConfig.PATH}/$it")
                .build()
                .toUri()
            ServerResponse.created(uri).build()
        }.awaitSingle()
    }

    suspend fun update(request: ServerRequest) : ServerResponse {
        service.update(Mono.just(request.pathVariable("id").toLong()),
                       request.bodyToMono(CarDto::class.java)).subscribe()
        return ServerResponse.noContent().build().awaitSingle()
    }

    suspend fun delete(request: ServerRequest) : ServerResponse {
        service.delete(Mono.just(request.pathVariable("id").toLong()))
        return ServerResponse.noContent().build().awaitSingle()
    }
}