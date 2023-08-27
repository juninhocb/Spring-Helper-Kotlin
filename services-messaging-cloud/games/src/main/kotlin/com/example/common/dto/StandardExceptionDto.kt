package com.example.common.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class StandardExceptionDto(
    val message: String,
    val path: String,
    @JsonProperty(value = "status_code") val statusCode: Int,
    val timestamp: String
)
