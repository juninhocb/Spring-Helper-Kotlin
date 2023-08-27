package com.example.teams.team

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TeamRepository : JpaRepository<Team, UUID> {

    fun findByName(name: String) : Optional<Team>

}