package com.example.carlosjr.simplemvcrestrelationship.mappers

import com.example.carlosjr.simplemvcrestrelationship.dtos.TeacherDto
import com.example.carlosjr.simplemvcrestrelationship.entities.Teacher
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class TeacherMapper {

    fun toTeacherDto(teacher: Teacher): TeacherDto {

        return TeacherDto(
            id = teacher.id,
            createdDate = LocalDateTime.from(teacher.createdTime),
            name = teacher.name,
            careerExperience = teacher.careerExperience
        )
    }

    fun toTeacherEntity(teacherDto: TeacherDto) : Teacher {
        return Teacher(
            name = teacherDto.name,
            careerExperience =  teacherDto.careerExperience
        )
    }

}