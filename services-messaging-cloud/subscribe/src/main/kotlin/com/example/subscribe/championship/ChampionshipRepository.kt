package com.example.subscribe.championship

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ChampionshipRepository : JpaRepository<Championship, UUID> {

    fun findByName(name: String) : Optional<Championship>

}