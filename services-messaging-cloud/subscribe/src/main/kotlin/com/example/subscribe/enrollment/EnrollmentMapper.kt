package com.example.subscribe.enrollment

import com.example.common.dto.EnrollmentDto
import com.example.subscribe.championship.ChampionshipMapper
import org.springframework.stereotype.Component

@Component
class EnrollmentMapper (private val championshipMapper: ChampionshipMapper){

    fun dtoToEntity(dto: EnrollmentDto) : Enrollment{

        return Enrollment(
            teamName = dto.teamName,
            championship = championshipMapper.dtoToEntity(dto.championship),
            isActive = dto.isActive
        )
    }


    fun entityToDto(entity: Enrollment) : EnrollmentDto {
        return EnrollmentDto(
            id = entity.id,
            teamName = entity.teamName,
            championship = championshipMapper.entityToDto(entity.championship),
            isActive = entity.isActive,
            createdAt = entity.createdAt
        )
    }
}