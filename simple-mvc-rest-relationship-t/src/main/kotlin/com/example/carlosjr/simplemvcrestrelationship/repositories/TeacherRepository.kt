package com.example.carlosjr.simplemvcrestrelationship.repositories

import com.example.carlosjr.simplemvcrestrelationship.entities.Teacher
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TeacherRepository : JpaRepository<Teacher, Long> {

    fun findByName(name: String) : Optional<Teacher>

}