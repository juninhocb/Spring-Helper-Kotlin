package com.example.common.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null
import java.time.LocalDateTime
import java.util.*

data class GameDto(
    @field:Null val id: UUID? = null,
    @field:Null val createdAt: LocalDateTime? = null,
    @field:NotBlank val team: String,
    @field:NotBlank val adversary: String,
    @field:NotNull val result: String,
    @field:NotNull val championship: String,
    @field:Null val status:String? = null
) {
    constructor() : this(null, null, "", "" ,"", "", "")
}
