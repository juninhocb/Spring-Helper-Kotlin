package com.example.subscribe.enrollment

import com.example.common.dto.EnrollmentDto
import java.util.*

interface EnrollmentService {

    fun verifyTeamEnrollment(enrollmentDto: EnrollmentDto) : Boolean

    fun create(enrollmentDto: EnrollmentDto) : UUID

    fun setActive(uuid: UUID, isActive: Boolean)

    fun getById(uuid: UUID) : EnrollmentDto

    fun getByTeamName(teamName: String) : EnrollmentDto

    fun findAll() : Set<EnrollmentDto>

}