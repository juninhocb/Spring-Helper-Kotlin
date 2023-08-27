package com.example.common.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Null
import java.time.LocalDateTime
import java.util.*

data class TeamDto(
    @field:Null val id: UUID? = null,
    @field:Null @JsonProperty("created_at") val createdAt: LocalDateTime? = null,
    @field:NotBlank var name: String
) {
    constructor() : this(null, null, "")
}
