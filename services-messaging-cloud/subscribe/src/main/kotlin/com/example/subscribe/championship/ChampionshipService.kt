package com.example.subscribe.championship

import com.example.common.dto.ChampionshipDto
import java.util.*

interface ChampionshipService {

    fun getByName(name: String) : ChampionshipDto

    fun getById(uuid: UUID) : ChampionshipDto

    fun create(championshipDto: ChampionshipDto) : UUID

}
