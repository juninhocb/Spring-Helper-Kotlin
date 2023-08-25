package com.example.carlosjr.simplemvcrestrelationship.mappers

import com.example.carlosjr.simplemvcrestrelationship.dtos.StudentDto
import com.example.carlosjr.simplemvcrestrelationship.entities.Student
import org.springframework.stereotype.Component

@Component
class StudentMapper(private val subjectMapper: SubjectMapper) : GenericMapper<StudentDto, Student> {

    override fun dtoToEntity(dto: StudentDto?) : Student? {
        if (dto != null) {
            return Student(
                name = dto.name,
                averageNotice = dto.averageNotice,
                subject = subjectMapper.dtoToEntity(dto.subjectDto)
            )
        }
        return null
    }

    override fun entityToDto(entity: Student?) : StudentDto? {
        if (entity != null) {
            return StudentDto(
                id = entity.id,
                createdTime =  entity.createdTime,
                name = entity.name,
                averageNotice = entity.averageNotice,
                subjectDto = subjectMapper.entityToDto(entity.subject)
            )
        }
        return null
    }

}