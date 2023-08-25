package com.example.carlosjr.simplemvcrestrelationship.mappers

import com.example.carlosjr.simplemvcrestrelationship.dtos.TeacherDto
import com.example.carlosjr.simplemvcrestrelationship.entities.Teacher
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class TeacherMapper(private val subjectMapper: SubjectMapper) : GenericMapper<TeacherDto, Teacher> {
    override fun dtoToEntity(dto: TeacherDto?): Teacher? {
        if (dto != null) {
            return Teacher(
                name = dto.name,
                careerExperience =  dto.careerExperience,
                subject = subjectMapper.dtoToEntity(dto.subjectDto)
            )
        }
        return null
    }

    override fun entityToDto(entity: Teacher?): TeacherDto? {
        if (entity != null) {
            return TeacherDto(
                id = entity.id,
                createdDate = LocalDateTime.from(entity.createdTime),
                name = entity.name,
                careerExperience = entity.careerExperience,
                subjectDto = subjectMapper.entityToDto(entity.subject)
            )
        }
        return null
    }

}