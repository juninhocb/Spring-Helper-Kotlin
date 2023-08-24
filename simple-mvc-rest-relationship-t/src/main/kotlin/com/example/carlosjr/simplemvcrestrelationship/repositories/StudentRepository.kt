package com.example.carlosjr.simplemvcrestrelationship.repositories

import com.example.carlosjr.simplemvcrestrelationship.entities.Student
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : GenericRepository<Student> {

}