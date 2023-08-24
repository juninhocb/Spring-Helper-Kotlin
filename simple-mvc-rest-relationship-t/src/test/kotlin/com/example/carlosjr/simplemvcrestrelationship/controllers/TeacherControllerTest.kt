package com.example.carlosjr.simplemvcrestrelationship.controllers

import com.example.carlosjr.simplemvcrestrelationship.dtos.StandardExceptionDto
import com.example.carlosjr.simplemvcrestrelationship.dtos.TeacherDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.net.URI

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TeacherControllerTest(@Autowired private val restTemplate: TestRestTemplate) {

    val path: String = "/api/v1/teachers"

    @Test
    fun getTeacherById() {
        val response: ResponseEntity<TeacherDto> =
            restTemplate.getForEntity("$path/1", TeacherDto::class.java)
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)

        println(response.body)

    }

    @Test
    fun getTeacherByName() {
        val response: ResponseEntity<TeacherDto> =
            restTemplate.getForEntity("$path/find?name=John Green", TeacherDto::class.java)
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)

        println(response.body)


    }

    @Test
    fun createTeacher() {

        val exceptionResponse: ResponseEntity<StandardExceptionDto> =
            restTemplate.getForEntity("$path/find?name=John Blue", StandardExceptionDto::class.java)
        assertThat(exceptionResponse.statusCode).isEqualTo(HttpStatus.NOT_FOUND)

        println(exceptionResponse.body)


        val createResponse:  ResponseEntity<Void> =
            restTemplate.postForEntity(path, getTeacherDto(), Void::class.java)

        assertThat(createResponse.statusCode).isEqualTo(HttpStatus.CREATED)

        val resourceLocale: URI = createResponse.headers.location!!

        val getResponse : ResponseEntity<TeacherDto> =
            restTemplate.getForEntity(resourceLocale, TeacherDto::class.java)

        assertThat(getResponse.statusCode).isEqualTo(HttpStatus.OK)

        println(getResponse.body)

    }

    private fun getTeacherDto() : TeacherDto {
        return TeacherDto(
            "John Blue",
            14
        )
    }

}