package com.example.carlosjr.simplemvcrestrelationship.services

import com.example.carlosjr.simplemvcrestrelationship.dtos.SubjectDto
import com.example.carlosjr.simplemvcrestrelationship.exceptions.ResourceNotFoundException
import com.example.carlosjr.simplemvcrestrelationship.mappers.SubjectMapper
import com.example.carlosjr.simplemvcrestrelationship.repositories.SubjectRepository
import org.springframework.stereotype.Service

@Service
class SubjectServiceImpl(private val subjectRepository: SubjectRepository,
                         private val subjectMapper: SubjectMapper) : GenericService<SubjectDto> {

    override fun getById(id: Long): SubjectDto {
        val subjectOpt =  subjectRepository.findById(id)

        if (subjectOpt.isEmpty){
            throw ResourceNotFoundException(id.toString())
        }

        return subjectMapper.entityToDto(subjectOpt.get())!!
    }

    override fun getByName(name: String): SubjectDto {
        val subjectOpt =  subjectRepository.findByName(name)

        if (subjectOpt.isEmpty){
            throw ResourceNotFoundException(name)
        }

        return subjectMapper.entityToDto(subjectOpt.get())!!
    }

    override fun create(subjectDto: SubjectDto): Long {
        val persistedSubject = subjectRepository
            .save(subjectMapper.dtoToEntity(subjectDto)!!)

        return persistedSubject.id!!
    }
}