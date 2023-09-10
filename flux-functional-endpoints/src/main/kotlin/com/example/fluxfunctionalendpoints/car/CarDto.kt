package com.example.fluxfunctionalendpoints.car

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class CarDto(
    val name: String,
    val velocity: Int,
    val id: Long?,
    @JsonProperty("created_at") val createdAt: LocalDateTime?
)
