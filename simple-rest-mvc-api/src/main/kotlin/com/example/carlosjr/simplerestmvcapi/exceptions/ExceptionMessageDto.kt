package com.example.carlosjr.simplerestmvcapi.exceptions

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

class ExceptionMessageDto {
    var message: String? = null
    lateinit var path: String
    @JsonProperty("status_code")
    var code: Int = 0
    lateinit var timestamp: LocalDateTime
 }