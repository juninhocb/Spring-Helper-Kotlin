package com.example.carlosjr.simplemvcrestrelationship.services

import com.example.carlosjr.simplemvcrestrelationship.dtos.SubjectDto

interface SubjectService {

    fun getSubjectById(id: Long) : SubjectDto
    fun getSubjectByName(name: String) : SubjectDto
    fun createSubject(subjectDto: SubjectDto) :  Long

}