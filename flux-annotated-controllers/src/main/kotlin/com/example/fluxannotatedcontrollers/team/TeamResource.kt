package com.example.fluxannotatedcontrollers.team

import jakarta.validation.Valid
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono


@RestController
@RequestMapping("/api/v1/team")
class TeamResource(private val service: TeamService) {

    @GetMapping
    fun getAll(pageable: Pageable) : Mono<ResponseEntity<Set<TeamDto>>> {
        val setTeamDto = service
            .getAll(
                PageRequest.of(
                               pageable.pageNumber,
                               pageable.pageSize,
                               Sort.DEFAULT_DIRECTION))
        return Mono.just(ResponseEntity(setTeamDto, HttpStatus.OK))
    }

    @GetMapping("/{teamId}")
    fun getById(@PathVariable(name = "teamId") id: Long) : Mono<ResponseEntity<TeamDto>> {
        return Mono.just(ResponseEntity(service.getById(id), HttpStatus.OK))
    }

    @PostMapping
    fun save(@RequestBody @Valid dto: TeamDto, ucb: UriComponentsBuilder) : Mono<ResponseEntity<Void>>{
        val id = service.save(dto)
        val uri = ucb
            .path("/api/v1/team/{id}")
            .buildAndExpand(id)
            .toUri()
        return Mono.just(ResponseEntity.created(uri).build())
    }

    @PutMapping("/{teamId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateTeam(@PathVariable teamId: Long,
                   @RequestBody @Valid dto: TeamDto) {
        service.update(teamId, dto)
    }

    @DeleteMapping("/{teamId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTeam(@PathVariable teamId: Long) {
        service.delete(teamId)
    }
}