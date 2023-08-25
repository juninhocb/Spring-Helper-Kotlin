package com.example.carlosjr.simplemvcrestrelationship.controllers

import com.example.carlosjr.simplemvcrestrelationship.dtos.StudentDto
import com.example.carlosjr.simplemvcrestrelationship.services.GenericService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/api/v1/students")
class StudentController(private val studentService: GenericService<StudentDto>) {

    @GetMapping("/{studentId}")
    fun getStudentById(@PathVariable studentId: Long) : ResponseEntity<StudentDto> {
        return ResponseEntity.ok().body(studentService.getById(studentId))
    }

    @GetMapping("/find")
    fun getStudentByName(@RequestParam(name = "name") name: String) : ResponseEntity<StudentDto> {
        return ResponseEntity.ok().body(studentService.getByName(name))
    }

    @PostMapping
    fun createStudent(@RequestBody @Valid studentDto: StudentDto,
                      ucb: UriComponentsBuilder) : ResponseEntity<Void> {

        val persistedResource = studentService.create(studentDto)

        val resourceLocation : URI = ucb
            .path("/api/v1/students/{id}")
            .buildAndExpand(persistedResource.id).toUri()

        return ResponseEntity.created(resourceLocation).build()

    }

}