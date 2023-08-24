package com.example.carlosjr.simplemvcrestrelationship.dtos

import com.fasterxml.jackson.annotation.JsonProperty

data class StandardExceptionDto(
    var message: String,
    var path: String,
    @JsonProperty("class") var className: String? = null,
    var timestamp: String,
    @JsonProperty("response_code") var responseCode: Int
)