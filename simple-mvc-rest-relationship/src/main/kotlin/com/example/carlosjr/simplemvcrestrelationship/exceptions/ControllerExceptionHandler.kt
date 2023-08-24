package com.example.carlosjr.simplemvcrestrelationship.exceptions

import com.example.carlosjr.simplemvcrestrelationship.dtos.StandardExceptionDto
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.text.SimpleDateFormat
import java.util.*

@ControllerAdvice
class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun resourceNotFoundHandler(ex: ResourceNotFoundException, httpServletRequest: HttpServletRequest) : ResponseEntity<StandardExceptionDto> {
        val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            StandardExceptionDto(
                ex.message!!,
                httpServletRequest.requestURI,
                ex.javaClass.toString(),
                formatter.format(Date()),
                HttpStatus.NOT_FOUND.value()
            )
        )

    }

}