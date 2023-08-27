package com.example.games.game

import com.example.common.dto.GameDto
import java.util.*

interface GameService {

    fun getById (id: UUID) : GameDto
    fun create (gameDto: GameDto) : UUID
    fun getAllByChampionship(championship: String) : Set<GameDto>
    fun getAllByTeam(team: String) : Set<GameDto>

}