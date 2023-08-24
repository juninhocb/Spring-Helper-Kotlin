package com.example.carlosjr.simplemvcrestrelationship.services

import com.example.carlosjr.simplemvcrestrelationship.dtos.StudentDto

interface StudentService {

    fun getStudentById(id: Long) : StudentDto
    fun getStudentByName(name: String) : StudentDto
    fun createStudent(studentDto: StudentDto) :  Long

}