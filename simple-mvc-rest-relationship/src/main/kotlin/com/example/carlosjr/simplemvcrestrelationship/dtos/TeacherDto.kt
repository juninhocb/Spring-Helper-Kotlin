package com.example.carlosjr.simplemvcrestrelationship.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null
import java.time.LocalDateTime

data class TeacherDto(
        @Null val id: Long? = null,
        @Null @JsonProperty(value = "created_date") val createdDate: LocalDateTime? = null,
        @NotBlank var name: String,
        @NotNull var careerExperience: Int,
        @JsonProperty(value = "subject") var subjectDto: SubjectDto? = null
) {
    constructor() : this(null, null,"", 0, null)
    constructor(nameConst: String, careerExperienceConst: Int) : this(null, null,
            name = nameConst ,  careerExperience = careerExperienceConst, null )
}
