package com.example.carlosjr.simplerestmvcapi.person

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PersonRepository : JpaRepository<Person, Long> {
    fun findByName(name: String) : Optional<Person>
}