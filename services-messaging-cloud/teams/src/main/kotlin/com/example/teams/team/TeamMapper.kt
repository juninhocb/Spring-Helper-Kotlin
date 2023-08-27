package com.example.teams.team

import com.example.common.dto.TeamDto
import org.springframework.stereotype.Component

@Component
class TeamMapper {

    fun entityToDto(entity: Team) : TeamDto {
        return TeamDto(
            id = entity.id,
            createdAt = entity.createdAt,
            name = entity.name
        )
    }

    fun dtoToEntity(dto: TeamDto) : Team {
        return Team(
            name = dto.name
        )
    }
}