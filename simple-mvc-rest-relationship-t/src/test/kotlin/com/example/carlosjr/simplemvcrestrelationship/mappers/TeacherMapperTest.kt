package com.example.carlosjr.simplemvcrestrelationship.mappers

import com.example.carlosjr.simplemvcrestrelationship.dtos.TeacherDto
import com.example.carlosjr.simplemvcrestrelationship.entities.Teacher
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TeacherMapperTest(@Autowired val teacherMapper: TeacherMapper) {

    @Test
    fun testMap(){
        val tea = Teacher("John Green", 15)
        teacherMapper.toTeacherDto(tea)
    }

    @Test
    fun testToEntity(){
        val dto = TeacherDto()
        dto.name = "Alex Red"
        dto.careerExperience = 15
        println(teacherMapper.toTeacherEntity(dto))
    }
}