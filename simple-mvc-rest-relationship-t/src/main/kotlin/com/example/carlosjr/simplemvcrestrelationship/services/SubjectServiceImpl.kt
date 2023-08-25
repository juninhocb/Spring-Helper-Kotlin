package com.example.carlosjr.simplemvcrestrelationship.services

import com.example.carlosjr.simplemvcrestrelationship.dtos.SubjectDto
import com.example.carlosjr.simplemvcrestrelationship.entities.Subject
import com.example.carlosjr.simplemvcrestrelationship.mappers.SubjectMapper
import com.example.carlosjr.simplemvcrestrelationship.repositories.SubjectRepository
import org.springframework.stereotype.Service

@Service
class SubjectServiceImpl(private val subjectRepository: SubjectRepository,
                         private val subjectMapper: SubjectMapper) : GenericServiceImpl<SubjectDto, Subject>(subjectRepository, subjectMapper) {

}