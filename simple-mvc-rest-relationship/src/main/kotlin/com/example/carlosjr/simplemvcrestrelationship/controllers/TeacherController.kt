package com.example.carlosjr.simplemvcrestrelationship.controllers


import com.example.carlosjr.simplemvcrestrelationship.dtos.TeacherDto
import com.example.carlosjr.simplemvcrestrelationship.services.TeacherService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/api/v1/teachers")
class TeacherController(private val teacherService: TeacherService) {

    @GetMapping("/{teacherId}")
    fun getTeacherById(@PathVariable teacherId: Long) : ResponseEntity<TeacherDto> {
        return ResponseEntity.ok().body(teacherService.getTeacherById(teacherId))
    }

    @GetMapping("/find")
    fun getTeacherByName(@RequestParam(name = "name") name: String) : ResponseEntity<TeacherDto> {
        return ResponseEntity.ok().body(teacherService.getTeacherByName(name))
    }

    @PostMapping
    fun createTeacher(@RequestBody @Valid teacherDto: TeacherDto,
                      ucb: UriComponentsBuilder
    ) : ResponseEntity<Void> {

        val resourceId = teacherService.createTeacher(teacherDto)

        val resourceLocation : URI = ucb
            .path("/api/v1/teachers/{id}")
            .buildAndExpand(resourceId).toUri()

        return ResponseEntity.created(resourceLocation).build()

    }

}