package com.example.carlosjr.simplerestmvcapi.person

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
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api/v1/person")
class PersonController(private val personService: PersonService) {

    @GetMapping("/{personId}")
    fun findById(@PathVariable personId: Long) : ResponseEntity<PersonDto> {
        return ResponseEntity.ok().body(personService.findById(personId))
    }
    @GetMapping("/find")
    fun findByName(@RequestParam(name = "name") name: String) : ResponseEntity<PersonDto>{
        return ResponseEntity.ok().body(personService.findByName(name))
    }
    @GetMapping
    fun findAll(pageable: Pageable) : ResponseEntity<Set<PersonDto>> {
        return ResponseEntity.ok().body(personService.findAll(
            PageRequest.of(
                pageable.pageNumber,
                pageable.pageSize,
                Sort.by(Sort.Direction.ASC, "id")
            )
        ))
    }
    @PostMapping
    fun create(@RequestBody @Valid personDto: PersonDto,
               ucb: UriComponentsBuilder) : ResponseEntity<Void>{
        val idPersisted = personService.create(personDto)
        val resourcePath =  ucb
            .path("/api/v1/person/{id}")
            .buildAndExpand(idPersisted)
            .toUri()
        return ResponseEntity.created(resourcePath).build()
    }

    @PutMapping("/{personId}")
    @ResponseStatus(HttpStatus.OK)
    fun update(@PathVariable personId: Long, @RequestBody @Valid personDto: PersonDto) {
        personService.update(personId, personDto)
    }

    @DeleteMapping("/{personId}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable(name = "personId") id: Long){
        personService.delete(id)
    }

}