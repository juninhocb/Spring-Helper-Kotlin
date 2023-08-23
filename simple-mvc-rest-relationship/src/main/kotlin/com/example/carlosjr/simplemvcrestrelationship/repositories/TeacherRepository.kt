package com.example.carlosjr.simplemvcrestrelationship.repositories

import com.example.carlosjr.simplemvcrestrelationship.entities.Teacher
import org.springframework.data.jpa.repository.JpaRepository

interface TeacherRepository : JpaRepository<Teacher, Long> {
}