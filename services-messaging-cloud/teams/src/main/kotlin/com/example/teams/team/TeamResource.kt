package com.example.teams.team

import com.example.common.dto.TeamDto
import jakarta.validation.Valid
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/api/v1/teams/team")
class TeamResource(private val service: TeamService) {

    @GetMapping("/{teamId}")
    fun getById(@PathVariable teamId: UUID) : ResponseEntity<TeamDto> {
        return ResponseEntity.ok().body(service.getById(teamId))
    }

    @GetMapping("/find")
    fun getById(@RequestParam(value = "team") team: String) : ResponseEntity<TeamDto> {
        return ResponseEntity.ok().body(service.getByName(team))
    }

    @PostMapping
    fun create(@RequestBody @Valid teamDto: TeamDto,
                ucb: UriComponentsBuilder) : ResponseEntity<Void> {

        val persistedId = service.create(teamDto)

        val resourceUrl : URI =
            ucb
                .path("/api/v1/teams/team/{id}")
                .buildAndExpand(persistedId)
                .toUri()

        return ResponseEntity.created(resourceUrl).build()
    }

    @PutMapping("/{teamId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@RequestBody @Valid teamDto: TeamDto, @PathVariable teamId: UUID){
        service.update(teamDto, teamId)
    }

    @GetMapping
    fun findAll(pageable: Pageable) : ResponseEntity<Set<TeamDto>> {
        val pageRequest =
            PageRequest.of(
                pageable.pageNumber,
                pageable.pageSize,
                Sort.by(Sort.Order.asc("id"))
            )

        return ResponseEntity.ok().body(service.findAll(pageRequest))

    }




}