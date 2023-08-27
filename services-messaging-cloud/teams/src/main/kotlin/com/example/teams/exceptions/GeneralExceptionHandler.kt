package com.example.subscribe.exceptions

import com.example.common.dto.StandardExceptionDto
import com.example.common.exceptions.ResourceNotFoundException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.text.SimpleDateFormat
import java.util.*

@ControllerAdvice
class GeneralExceptionHandler {

    @ExceptionHandler(RuntimeException::class)
    fun handleGenericException(exception: RuntimeException, httpServletRequest: HttpServletRequest)
            : ResponseEntity<StandardExceptionDto> {

        val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm:ss ")

        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(
                StandardExceptionDto(
                    exception.message!!,
                    httpServletRequest.requestURI,
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    formatter.format(Date())))
    }


    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFound(exception: ResourceNotFoundException, httpServletRequest: HttpServletRequest)
        : ResponseEntity<StandardExceptionDto> {

        val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm:ss ")

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(
                StandardExceptionDto(
                exception.message!!,
                httpServletRequest.requestURI,
                HttpStatus.NOT_FOUND.value(),
                formatter.format(Date())))
    }



}