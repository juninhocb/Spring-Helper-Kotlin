package com.example.carlosjr.simplemvcrestrelationship.mappers

import com.example.carlosjr.simplemvcrestrelationship.dtos.SubjectDto
import com.example.carlosjr.simplemvcrestrelationship.entities.Subject
import org.springframework.stereotype.Component

@Component
class SubjectMapper {

    fun dtoToEntity(subjectDto: SubjectDto) : Subject{
        return Subject(
            name = subjectDto.name
        )
    }

    fun entityToDto(subject: Subject) : SubjectDto {
        return SubjectDto(
            id = subject.id,
            createdTime = subject.createdTime,
            name = subject.name
        )
    }

}