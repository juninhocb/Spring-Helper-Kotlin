package com.example.carlosjr.simplemvcrestrelationship.services

import com.example.carlosjr.simplemvcrestrelationship.dtos.StudentDto
import com.example.carlosjr.simplemvcrestrelationship.mappers.SubjectMapper
import com.example.carlosjr.simplemvcrestrelationship.repositories.SubjectRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class StudentServiceImplTest(@Autowired val subjectRepository: SubjectRepository,
                             @Autowired val studentService: StudentService,
                             @Autowired val subjectMapper: SubjectMapper   ) {

    @Test
    fun createStudent() {

        val subjectDto = subjectMapper
            .entityToDto(subjectRepository.findAll()[0])

        val studentDto = StudentDto(
            null, null, "Peter Black", 6, subjectDto
        )

        val resourceId = studentService.createStudent(studentDto)

        assertThat(resourceId).isNotNull()

        val persistedStudent = studentService.getStudentByName("Peter Black")

        assertThat(persistedStudent).isNotNull()

        println(persistedStudent)

    }
}