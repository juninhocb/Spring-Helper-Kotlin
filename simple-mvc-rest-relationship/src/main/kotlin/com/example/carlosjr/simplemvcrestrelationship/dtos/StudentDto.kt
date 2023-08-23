package com.example.carlosjr.simplemvcrestrelationship.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null
import java.time.LocalDateTime

data class StudentDto (
    @Null val id: Long? = null,
    @Null @JsonProperty("created_time") val createdTime: LocalDateTime? = null,
    @NotBlank var name: String,
    @NotNull  @JsonProperty("average_notice") var averageNotice: Int
) {
    constructor() : this(null, null, "", 0)
}