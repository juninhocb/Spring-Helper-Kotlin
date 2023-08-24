package com.example.carlosjr.simplemvcrestrelationship.services

import com.example.carlosjr.simplemvcrestrelationship.dtos.StudentDto
import com.example.carlosjr.simplemvcrestrelationship.dtos.TeacherDto
import com.example.carlosjr.simplemvcrestrelationship.entities.Student
import com.example.carlosjr.simplemvcrestrelationship.exceptions.ResourceNotFoundException
import com.example.carlosjr.simplemvcrestrelationship.mappers.StudentMapper
import com.example.carlosjr.simplemvcrestrelationship.repositories.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentServiceImpl(private val studentRepository: StudentRepository,
                         private val studentMapper: StudentMapper) : GenericServiceImpl<StudentDto, Student>(studentRepository, studentMapper) {



}