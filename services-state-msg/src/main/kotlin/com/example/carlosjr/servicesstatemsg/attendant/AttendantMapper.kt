package com.example.carlosjr.servicesstatemsg.attendant

import com.example.carlosjr.coffebar.dtos.AttendantDto
import org.springframework.stereotype.Component

@Component
class AttendantMapper {

    fun dtoToEntity(dto: AttendantDto) : Attendant{
        return Attendant(
            name = dto.name
        )
    }

    fun entityToDto(entity: Attendant) : AttendantDto {
        return AttendantDto(
            id = entity.id,
            name = entity.name,
            createdAt = entity.createdAt
        )
    }

}