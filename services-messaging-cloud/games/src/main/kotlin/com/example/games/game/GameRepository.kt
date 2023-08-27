package com.example.games.game

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface GameRepository : JpaRepository<Game, UUID> {

    fun findGamesByTeam(team: String) : List<Game>

    fun findGamesByChampionship(championship: String) : List<Game>

}