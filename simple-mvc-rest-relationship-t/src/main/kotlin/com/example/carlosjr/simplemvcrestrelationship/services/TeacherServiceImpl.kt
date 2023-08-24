package com.example.carlosjr.simplemvcrestrelationship.services

import com.example.carlosjr.simplemvcrestrelationship.dtos.TeacherDto
import com.example.carlosjr.simplemvcrestrelationship.entities.Teacher
import com.example.carlosjr.simplemvcrestrelationship.mappers.TeacherMapper
import com.example.carlosjr.simplemvcrestrelationship.repositories.TeacherRepository
import org.springframework.stereotype.Service

@Service
class TeacherServiceImpl(private val teacherRepository: TeacherRepository,
                         private val teacherMapper: TeacherMapper) : GenericServiceImpl<TeacherDto, Teacher>(teacherRepository, teacherMapper) {

    fun greetingsForTeacher() : String{
        val testEntity =  teacherRepository.findById(1L)

        return "Hello Teacher ${teacherMapper.entityToDto(testEntity.get()).name}. This is the greetings!"
    }
}