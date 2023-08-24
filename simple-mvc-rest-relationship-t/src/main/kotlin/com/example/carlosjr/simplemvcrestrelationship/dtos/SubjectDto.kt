package com.example.carlosjr.simplemvcrestrelationship.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Null
import java.time.LocalDateTime

data class SubjectDto(
    @field:Null val id: Long? = null,
    @field:Null @JsonProperty("created_time") val createdTime: LocalDateTime? = null,
    @field:NotBlank var name: String
)  {
    constructor() : this(null, null, "")
}