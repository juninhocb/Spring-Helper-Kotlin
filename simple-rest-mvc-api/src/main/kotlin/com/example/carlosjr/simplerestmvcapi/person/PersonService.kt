package com.example.carlosjr.simplerestmvcapi.person

import org.springframework.data.domain.Pageable

interface PersonService {

    fun getRepositorySize() : Long
    fun findById(id: Long) : PersonDto
    fun findByName(name: String) : PersonDto
    fun findAll(pageable: Pageable) : Set<PersonDto>
    fun create(personDto : PersonDto) : Long?
    fun createAll(people: List<PersonDto>)
    fun update(id: Long, personDto: PersonDto)
    fun delete(id: Long)
}