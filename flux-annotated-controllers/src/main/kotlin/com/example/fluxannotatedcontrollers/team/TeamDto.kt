package com.example.fluxannotatedcontrollers.team

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null
import jakarta.validation.constraints.Positive
import java.time.LocalDateTime

data class TeamDto (
    @field:Null val id: Long? = null,
    @field:NotBlank val name: String,
    @field:Positive @field:NotNull val titles: Int,
    @JsonProperty("created_time") @field:Null val createdTime: LocalDateTime? = null
)