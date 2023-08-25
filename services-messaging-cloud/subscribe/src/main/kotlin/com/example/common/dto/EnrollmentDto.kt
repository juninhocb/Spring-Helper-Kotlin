package com.example.common.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null
import java.time.LocalDateTime
import java.util.*

data class EnrollmentDto(
    @field:Null val id: UUID? = null,
    @field:NotBlank @JsonProperty(value = "team") var teamName: String,
    @field:NotNull var championship: ChampionshipDto,
    @JsonProperty(value = "is_active") var isActive: Boolean,
    @field:Null
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern =  "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone =  "GMT")
    @JsonProperty(value = "created_at") val createdAt: LocalDateTime? = null
) {
    constructor() : this(null, "", ChampionshipDto(), false, null)
}
