package com.example.carlosjr.simplerestmvcapi.person

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null
import java.time.LocalDateTime

data class PersonDto (
    @Null var id: Long,
    @NotBlank var name: String,
    @NotNull var age: Int,
    @NotNull @JsonProperty("alive") var isAlive: Boolean,
    @Null @JsonProperty("created") var createdTime: LocalDateTime
)