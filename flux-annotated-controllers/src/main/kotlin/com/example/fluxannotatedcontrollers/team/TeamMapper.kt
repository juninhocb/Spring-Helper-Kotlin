package com.example.fluxannotatedcontrollers.team

import org.springframework.stereotype.Component

@Component
class TeamMapper {

    fun dtoToEntity(dto: TeamDto) : Team {
        return Team(
            name = dto.name,
            titles = dto.titles
        )
    }

    fun entityToDto(entity: Team) : TeamDto{
        return TeamDto(
            id = entity.id,
            name = entity.name,
            titles = entity.titles,
            createdTime = entity.createdTime
        )
    }
}