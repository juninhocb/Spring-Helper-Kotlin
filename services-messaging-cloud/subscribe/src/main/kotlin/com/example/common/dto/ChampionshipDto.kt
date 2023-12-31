package com.example.common.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Null
import jakarta.validation.constraints.Size
import java.time.LocalDateTime
import java.util.*

data class ChampionshipDto (
    @field:Null val id: UUID? = null,
    @field:NotBlank @field:Size(min = 3, max = 36) var name: String,
    @field:Null
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern =  "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone =  "GMT")
    @JsonProperty(value = "created_at")
    val createdAt: LocalDateTime? = null
) {
    constructor() : this(null, "", null)
}