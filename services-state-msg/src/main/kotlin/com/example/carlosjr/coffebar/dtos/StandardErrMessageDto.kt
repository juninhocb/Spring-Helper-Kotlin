package com.example.carlosjr.coffebar.dtos

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class StandardErrMessageDto(
    val message: String,
    val path: String,
    @JsonProperty("status_code")
    val code: Int,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern =  "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone =  "GMT")
    val timestamp: LocalDateTime
) {

}
