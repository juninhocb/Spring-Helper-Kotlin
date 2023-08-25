package com.example.subscribe.championship

import com.example.common.dto.ChampionshipDto
import org.springframework.stereotype.Component

@Component
class ChampionshipMapper {

    fun dtoToEntity(dto: ChampionshipDto) : Championship {
        return Championship(name = dto.name)
    }

    fun entityToDto(entity: Championship) : ChampionshipDto {
        return ChampionshipDto(
            id = entity.id,
            name = entity.name,
            createdAt = entity.createdAt
        )
    }
}