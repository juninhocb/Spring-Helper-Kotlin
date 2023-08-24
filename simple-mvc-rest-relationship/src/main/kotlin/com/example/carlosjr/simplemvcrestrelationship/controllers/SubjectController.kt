package com.example.carlosjr.simplemvcrestrelationship.controllers

import com.example.carlosjr.simplemvcrestrelationship.dtos.SubjectDto
import com.example.carlosjr.simplemvcrestrelationship.services.SubjectService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/api/v1/subjects")
class SubjectController(private val subjectService: SubjectService) {

    @GetMapping("/{subjectId}")
    fun getSubjectById(@PathVariable subjectId: Long) : ResponseEntity<SubjectDto> {
        return ResponseEntity.ok().body(subjectService.getSubjectById(subjectId))
    }

    @GetMapping("/find")
    fun getSubjectByName(@RequestParam(name = "name") name: String) : ResponseEntity<SubjectDto> {
        return ResponseEntity.ok().body(subjectService.getSubjectByName(name))
    }

    @PostMapping
    fun createSubject(@RequestBody @Valid subjectDto: SubjectDto,
                      ucb: UriComponentsBuilder
    ) : ResponseEntity<Void> {

        val resourceId = subjectService.createSubject(subjectDto)

        val resourceLocation : URI = ucb
            .path("/api/v1/subjects/{id}")
            .buildAndExpand(resourceId).toUri()

        return ResponseEntity.created(resourceLocation).build()

    }

}