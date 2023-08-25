package com.example.subscribe.enrollment

import com.example.common.dto.EnrollmentDto
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.util.*

@RestController
@RequestMapping("/api/v1/subscribe/enrollment")
class EnrollmentResource(private val service: EnrollmentService) {

    @GetMapping("/{enrollmentId}")
    fun getById(@PathVariable enrollmentId: UUID) : ResponseEntity<EnrollmentDto> {
        return ResponseEntity.ok().body(service.getById(enrollmentId))
    }

    @GetMapping("/find")
    fun getByName(@RequestParam(name = "name") name: String) : ResponseEntity<EnrollmentDto> {
        return ResponseEntity.ok().body(service.getByTeamName(name))
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun setActive(@RequestParam(name = "id") uuid: UUID,
                  @RequestParam(name = "isActive") isActive: String) {

        service.setActive(uuid, isActive as Boolean)
    }

    @PostMapping
    fun create(@RequestBody @Valid enrollmentDto: EnrollmentDto,
               ucb: UriComponentsBuilder) : ResponseEntity<Void> {

        val resourceId = service.create(enrollmentDto)

        val resourceUri =
            ucb
                .path("/api/v1/subscribe/enrollment/{id}")
                .buildAndExpand(resourceId)
                .toUri()

        return ResponseEntity.created(resourceUri).build()
    }

    @GetMapping("/validate")
    fun validateTeam(@RequestBody @Valid enrollmentDto: EnrollmentDto) : ResponseEntity<String> {

        val responseString = if(service.verifyTeamEnrollment(enrollmentDto))  "ok" else "invalid"

        return ResponseEntity.ok().body(responseString)

    }



}