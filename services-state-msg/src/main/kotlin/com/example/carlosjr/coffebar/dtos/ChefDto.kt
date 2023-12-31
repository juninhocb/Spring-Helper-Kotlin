package com.example.carlosjr.coffebar.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Null
import java.io.Serializable
import java.time.LocalDateTime
import java.util.*

data class ChefDto(

    @field:Null
    val id: UUID? = null,
    @field:Null @JsonProperty("created_at")
    val createdAt: LocalDateTime? = null,
    @field:NotBlank
    var name: String,
    var isAvailable: Boolean? = false
) : Serializable {
    companion object{
        const val serialVersionUID = 1L
    }
    constructor() : this(null, null, "", false)
}

