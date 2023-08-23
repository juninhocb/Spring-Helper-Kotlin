package com.example.carlosjr.simplemvcrestrelationship.bootstrap

import com.example.carlosjr.simplemvcrestrelationship.entities.Student
import com.example.carlosjr.simplemvcrestrelationship.repositories.StudentRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class InitDataTest(@Autowired val studentRepository: StudentRepository) {

    @Test
    fun printStoredSubject() {
        val persistedStudent: Student = studentRepository.findById(1L).get();
        println(persistedStudent.subject)
    }

}