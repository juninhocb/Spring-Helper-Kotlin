package com.example.carlosjr.servicesstatemsg.attendant

import com.example.carlosjr.coffebar.dtos.StandardErrMessageDto
import com.example.carlosjr.coffebar.exceptions.ResourceNotFoundException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
class AttendanceHandlerController {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun resourceNotFoundHandler(e: ResourceNotFoundException,
                                httpRequest: HttpServletRequest)
            : ResponseEntity<StandardErrMessageDto>{

        return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(
                        StandardErrMessageDto(
                        message = e.message!!,
                        path = httpRequest.requestURI,
                        code = HttpStatus.NOT_FOUND.value(),
                        timestamp = LocalDateTime.now()
                        )
                    )
    }

}