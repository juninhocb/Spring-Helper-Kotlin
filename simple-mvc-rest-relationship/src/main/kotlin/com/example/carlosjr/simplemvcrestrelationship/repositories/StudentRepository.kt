package com.example.carlosjr.simplemvcrestrelationship.repositories

import com.example.carlosjr.simplemvcrestrelationship.entities.Student
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface StudentRepository : JpaRepository<Student, Long> {

    fun findByName(name: String) : Optional<Student>

}