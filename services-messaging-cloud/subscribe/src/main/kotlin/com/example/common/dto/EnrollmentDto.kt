package com.example.common.dto

import com.example.subscribe.championship.Championship
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null
import java.time.LocalDateTime
import java.util.*

data class EnrollmentDto(
    @field:Null val id: UUID? = null,
    @field:NotBlank @JsonProperty(value = "team") var teamName: String,
    @field:NotNull var championship: Championship,
    @field:Null @JsonProperty(value = "is_active") var isActive: Boolean,
    @field:Null @JsonProperty(value = "created_at") val createdAt: LocalDateTime? = null
) {
    constructor() : this(null, "", Championship(), false, null)
}
