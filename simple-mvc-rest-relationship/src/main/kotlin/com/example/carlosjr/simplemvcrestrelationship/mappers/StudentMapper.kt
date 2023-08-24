package com.example.carlosjr.simplemvcrestrelationship.mappers

import com.example.carlosjr.simplemvcrestrelationship.dtos.StudentDto
import com.example.carlosjr.simplemvcrestrelationship.entities.Student
import org.springframework.stereotype.Component

@Component
class StudentMapper(private val subjectMapper: SubjectMapper) {

    fun dtoToEntity(studentDto: StudentDto) : Student {
        return Student(
            name = studentDto.name,
            averageNotice = studentDto.averageNotice,
            subject = subjectMapper.dtoToEntity(studentDto.subjectDto)
        )
    }

    fun entityToDto(student: Student) : StudentDto {
        return StudentDto(
            id = student.id,
            createdTime =  student.createdTime,
            name = student.name,
            averageNotice = student.averageNotice,
            subjectDto = subjectMapper.entityToDto(student.subject)
        )
    }

}