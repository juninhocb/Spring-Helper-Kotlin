package com.example.subscribe.enrollment

import com.example.common.dto.EnrollmentDto
import com.example.common.exceptions.ResourceNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class EnrollmentServiceImpl(private val repository: EnrollmentRepository,
                            private val mapper: EnrollmentMapper) : EnrollmentService {

    override fun verifyTeamEnrollment(enrollmentDto: EnrollmentDto): Boolean {

        val enrollmentOpt = repository
            .findByTeamAndChampionship(enrollmentDto.teamName, enrollmentDto.championship.name)

        if (enrollmentOpt.isEmpty){
            return false
        }

        return enrollmentOpt.get().isActive

    }

    override fun create(enrollmentDto: EnrollmentDto): UUID {

        enrollmentDto.isActive = true

        val persistedResource = repository.save(mapper.dtoToEntity(enrollmentDto))

        return persistedResource.id!!

    }

    override fun setActive(uuid: UUID,  isActive: Boolean) {

        repository.updateIsActive(isActive, uuid)

    }

    override fun getById(uuid: UUID): EnrollmentDto {

        val enrollmentOpt = repository.findById(uuid)

        if (enrollmentOpt.isEmpty){
            throw ResourceNotFoundException(uuid.toString())
        }

        return mapper.entityToDto(enrollmentOpt.get())

    }

    override fun getByTeamName(teamName: String): EnrollmentDto {

        val enrollmentOpt = repository.findByTeamName(teamName)

        if (enrollmentOpt.isEmpty){
            throw ResourceNotFoundException(teamName)
        }

        return mapper.entityToDto(enrollmentOpt.get())
    }
}