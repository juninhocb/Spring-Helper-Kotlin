package com.example.carlosjr.simplemvcrestrelationship.controllers

import com.example.carlosjr.simplemvcrestrelationship.dtos.StudentDto
import com.example.carlosjr.simplemvcrestrelationship.services.StudentService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/api/v1/students")
class StudentController(private val studentService: StudentService) {

    @GetMapping("/{studentId}")
    fun getStudentById(@PathVariable studentId: Long) : ResponseEntity<StudentDto> {
        return ResponseEntity.ok().body(studentService.getStudentById(studentId))
    }

    @GetMapping("/find")
    fun getStudentByName(@RequestParam(name = "name") name: String) : ResponseEntity<StudentDto> {
        return ResponseEntity.ok().body(studentService.getStudentByName(name))
    }

    @PostMapping
    fun createStudent(@RequestBody @Valid studentDto: StudentDto,
                      ucb: UriComponentsBuilder) : ResponseEntity<Void> {

        val resourceId = studentService.createStudent(studentDto)

        val resourceLocation : URI = ucb
            .path("/api/v1/students/{id}")
            .buildAndExpand(resourceId).toUri()

        return ResponseEntity.created(resourceLocation).build()

    }

}