package com.example.carlosjr.simplemvcrestrelationship.mappers

import com.example.carlosjr.simplemvcrestrelationship.dtos.SubjectDto
import com.example.carlosjr.simplemvcrestrelationship.entities.Subject
import org.springframework.stereotype.Component

@Component
class SubjectMapper : GenericMapper<SubjectDto, Subject>{

    override fun dtoToEntity(dto: SubjectDto?) : Subject?{
        if (dto != null) {
            return Subject(
                id = dto.id,
                createdTime = dto.createdTime,
                name = dto.name
            )
        }
        return null
    }

    override fun entityToDto(entity: Subject?) : SubjectDto? {
        if (entity != null) {
            return SubjectDto(
                id = entity.id,
                createdTime = entity.createdTime,
                name = entity.name
            )
        }
        return null
    }



}