package com.example.carlosjr.simplemvcrestrelationship.services

import com.example.carlosjr.simplemvcrestrelationship.dtos.StudentDto
import com.example.carlosjr.simplemvcrestrelationship.exceptions.ResourceNotFoundException
import com.example.carlosjr.simplemvcrestrelationship.mappers.StudentMapper
import com.example.carlosjr.simplemvcrestrelationship.repositories.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentServiceImpl(private val studentRepository: StudentRepository,
                         private val studentMapper: StudentMapper) : StudentService {

    override fun getStudentById(id: Long): StudentDto {

        val studentOpt =  studentRepository.findById(id)

        if (studentOpt.isEmpty){
            throw ResourceNotFoundException(id.toString())
        }

        return studentMapper.entityToDto(studentOpt.get())
    }

    override fun getStudentByName(name: String): StudentDto {

        val studentOpt = studentRepository.findByName(name)

        if (studentOpt.isEmpty){
            throw ResourceNotFoundException(name)
        }

        return studentMapper.entityToDto(studentOpt.get())
    }

    override fun createStudent(studentDto: StudentDto): Long {

        val persistedStudent = studentRepository
            .save(studentMapper.dtoToEntity(studentDto))

        return persistedStudent.id!!
    }



}