package com.example.common.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null
import java.io.Serializable
import java.time.LocalDateTime
import java.util.*

data class GameDto(
    @field:Null val id: UUID? = null,
    @field:Null val createdAt: LocalDateTime? = null,
    @field:NotBlank var team: String,
    @field:NotBlank var adversary: String,
    @field:NotNull var result: String,
    @field:NotNull var championship: String,
    @field:Null var status:String? = null
) : Serializable {

    companion object {
        private const val serialVersionUID: Long = 1L
    }

    constructor() : this(null, null, "", "" ,"", "", "")

    constructor(team: String,
                adversary: String,
                result: String,
                championship: String) : this(null, null, team, adversary, result, championship, null)
}
