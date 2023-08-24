package com.example.carlosjr.simplemvcrestrelationship.mappers

import com.example.carlosjr.simplemvcrestrelationship.dtos.SubjectDto
import com.example.carlosjr.simplemvcrestrelationship.entities.Subject
import org.springframework.stereotype.Component

@Component
class SubjectMapper {

    fun dtoToEntity(subjectDto: SubjectDto?) : Subject?{
        if (subjectDto != null) {
            return Subject(
                id = subjectDto.id,
                createdTime = subjectDto.createdTime,
                name = subjectDto.name
            )
        }
        return null
    }

    fun entityToDto(subject: Subject?) : SubjectDto? {
        if (subject != null) {
            return SubjectDto(
                id = subject.id,
                createdTime = subject.createdTime,
                name = subject.name
            )
        }
        return null
    }

}