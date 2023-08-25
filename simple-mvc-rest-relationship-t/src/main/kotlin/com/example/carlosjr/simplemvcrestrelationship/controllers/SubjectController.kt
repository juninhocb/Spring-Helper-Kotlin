package com.example.carlosjr.simplemvcrestrelationship.controllers

import com.example.carlosjr.simplemvcrestrelationship.dtos.SubjectDto
import com.example.carlosjr.simplemvcrestrelationship.services.GenericService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/api/v1/subjects")
class SubjectController(private val subjectService: GenericService<SubjectDto>) {

    @GetMapping("/{subjectId}")
    fun getSubjectById(@PathVariable subjectId: Long) : ResponseEntity<SubjectDto> {
        return ResponseEntity.ok().body(subjectService.getById(subjectId))
    }

    @GetMapping("/find")
    fun getSubjectByName(@RequestParam(name = "name") name: String) : ResponseEntity<SubjectDto> {
        return ResponseEntity.ok().body(subjectService.getByName(name))
    }

    @PostMapping
    fun createSubject(@RequestBody @Valid subjectDto: SubjectDto,
                      ucb: UriComponentsBuilder
    ) : ResponseEntity<Void> {

        val persistedResource = subjectService.create(subjectDto)

        val resourceLocation : URI = ucb
            .path("/api/v1/subjects/{id}")
            .buildAndExpand(persistedResource.id).toUri()

        return ResponseEntity.created(resourceLocation).build()

    }

}