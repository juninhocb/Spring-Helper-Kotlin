package com.example.carlosjr.simplemvcrestrelationship.services

import com.example.carlosjr.simplemvcrestrelationship.dtos.TeacherDto
import com.example.carlosjr.simplemvcrestrelationship.exceptions.ResourceNotFoundException
import com.example.carlosjr.simplemvcrestrelationship.mappers.TeacherMapper
import com.example.carlosjr.simplemvcrestrelationship.repositories.TeacherRepository
import org.springframework.stereotype.Service

@Service
class TeacherServiceImpl(private val teacherRepository: TeacherRepository,
                         private val teacherMapper: TeacherMapper) : TeacherService {

    override fun getTeacherById(id: Long): TeacherDto {

        val teacherOpt =  teacherRepository.findById(id)

        if (teacherOpt.isEmpty){
            throw ResourceNotFoundException(id.toString())
        }

        return teacherMapper.toTeacherDto(teacherOpt.get())
    }

    override fun getTeacherByName(name: String): TeacherDto {

        val teacherOpt =  teacherRepository.findByName(name)

        if (teacherOpt.isEmpty){
            throw ResourceNotFoundException(name)
        }

        return teacherMapper.toTeacherDto(teacherOpt.get())
    }

    override fun createTeacher(teacherDto: TeacherDto): Long {

        val persistedTeacher = teacherRepository
            .save(teacherMapper.toTeacherEntity(teacherDto))

        return persistedTeacher.id!!
    }
}