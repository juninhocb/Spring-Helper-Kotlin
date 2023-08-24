package com.example.carlosjr.simplemvcrestrelationship.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null
import jakarta.validation.constraints.Positive
import java.time.LocalDateTime
 data class TeacherDto(
        @field:Null val id: Long? = null,
        @field:Null @JsonProperty(value = "created_date") val createdDate: LocalDateTime? = null,
        @field:NotBlank var name: String,
        @field:Positive @field:NotNull @JsonProperty("experience") var careerExperience: Int,
        @field:Null @JsonProperty(value = "subject") var subjectDto: SubjectDto? = null
) {
    constructor() : this(null, null,"", 0, null)
    constructor(nameConst: String, careerExperienceConst: Int) : this(null, null,
            name = nameConst ,  careerExperience = careerExperienceConst, null )
}
