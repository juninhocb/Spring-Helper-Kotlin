package com.example.fluxannotatedcontrollers.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import reactor.core.publisher.Mono

@ControllerAdvice
class GlobalHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFound(ex: ResourceNotFoundException) : Mono<ResponseEntity<String>> {
        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.message))
    }

}