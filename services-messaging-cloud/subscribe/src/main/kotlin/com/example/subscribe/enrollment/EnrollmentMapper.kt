package com.example.subscribe.enrollment

import com.example.common.dto.EnrollmentDto
import org.springframework.stereotype.Component

@Component
class EnrollmentMapper (){

    fun dtoToEntity(dto: EnrollmentDto) : Enrollment{

        return Enrollment(
            teamName = dto.teamName,
            championship = dto.championship,
            isActive = dto.isActive
        )
    }


    fun entityToDto(entity: Enrollment) : EnrollmentDto {
        return EnrollmentDto(
            id = entity.id,
            teamName = entity.teamName,
            championship = entity.championship,
            isActive = entity.isActive,
            createdAt = entity.createdAt
        )
    }
}