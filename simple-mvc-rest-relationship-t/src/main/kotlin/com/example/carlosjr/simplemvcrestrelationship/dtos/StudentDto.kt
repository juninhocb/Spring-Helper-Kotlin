package com.example.carlosjr.simplemvcrestrelationship.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null
import jakarta.validation.constraints.Positive
import java.time.LocalDateTime

data class StudentDto (
    @field:Null val id: Long? = null,
    @field:Null @JsonProperty("created_time") val createdTime: LocalDateTime? = null,
    @field:NotBlank var name: String,
    @field:NotNull @field:Positive @JsonProperty("average_notice") var averageNotice: Int,
    @field:Null @JsonProperty("subject") var subjectDto: SubjectDto? = null
) {
    constructor() : this(null, null, "", 0, null)
}