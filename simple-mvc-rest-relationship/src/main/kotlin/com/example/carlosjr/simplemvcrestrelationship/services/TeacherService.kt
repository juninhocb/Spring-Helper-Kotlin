package com.example.carlosjr.simplemvcrestrelationship.services


import com.example.carlosjr.simplemvcrestrelationship.dtos.TeacherDto

interface TeacherService {

    fun getTeacherById(id: Long) : TeacherDto
    fun getTeacherByName(name: String) : TeacherDto
    fun createTeacher(teacherDto: TeacherDto) :  Long

}