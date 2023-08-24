package com.example.carlosjr.simplemvcrestrelationship.repositories

import com.example.carlosjr.simplemvcrestrelationship.entities.Subject
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SubjectRepository : JpaRepository<Subject, Long> {

    fun findByName(name: String) : Optional<Subject>

}