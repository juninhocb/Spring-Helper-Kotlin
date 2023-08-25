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
                             @Autowired val studentService: GenericService<StudentDto>,
                             @Autowired val subjectMapper: SubjectMapper   ) {

    @Test
    fun createStudent() {

        val subjectDto = subjectMapper
            .entityToDto(subjectRepository.findAll()[0])

        val studentDto = StudentDto(
            null, null, "Peter Black", 6, subjectDto
        )

        val resourceId = studentService.create(studentDto)

        assertThat(resourceId).isNotNull()

        val persistedStudent = studentService.getByName("Peter Black")

        assertThat(persistedStudent).isNotNull()

        println(persistedStudent)

    }
}