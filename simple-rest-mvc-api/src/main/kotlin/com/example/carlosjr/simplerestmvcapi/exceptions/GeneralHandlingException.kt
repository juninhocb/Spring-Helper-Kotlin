package com.example.carlosjr.simplerestmvcapi.exceptions

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
class GeneralHandlingException{


    @ExceptionHandler(ResourceNotFoundException::class)
    fun resourceNotFoundHandler(ex: ResourceNotFoundException,
                                httpServletRequest: HttpServletRequest) : ResponseEntity<ExceptionMessageDto> {

        val exceptionMessage = getResponseMessage(
            ex.message,
            HttpStatus.NOT_FOUND.value(),
            httpServletRequest.requestURI
        )

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionMessage)
    }

    private fun getResponseMessage(msg: String?, code: Int, path: String) : ExceptionMessageDto {
        val exceptionMessageDto = ExceptionMessageDto()
        exceptionMessageDto.message = msg
        exceptionMessageDto.code = code
        exceptionMessageDto.path = path
        exceptionMessageDto.timestamp = LocalDateTime.now()
        return exceptionMessageDto
    }

}