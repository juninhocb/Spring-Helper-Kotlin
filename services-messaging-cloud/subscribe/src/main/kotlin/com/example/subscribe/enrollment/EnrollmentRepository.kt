package com.example.subscribe.enrollment

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface EnrollmentRepository : JpaRepository<Enrollment, UUID> {

    @Query("SELECT e FROM  Enrollment e WHERE e.teamName = :name AND e.championship.name = :championshipName")
    fun findByTeamAndChampionship(@Param("name") teamName: String, @Param("championshipName") championshipName: String) : Optional<Enrollment>

    @Modifying
    @Query("UPDATE Enrollment e SET e.isActive = :isActive WHERE e.id = :uuid ")
    fun updateIsActive(@Param("isActive") isActive: Boolean, @Param("uuid") uuid: UUID)

    fun findByTeamName(teamName: String) : Optional<Enrollment>

}