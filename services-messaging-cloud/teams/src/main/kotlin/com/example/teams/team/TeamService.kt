package com.example.teams.team

import com.example.common.dto.TeamDto
import org.springframework.data.domain.Pageable
import java.util.*

interface TeamService {

    fun getById(id: UUID) : TeamDto
    fun getPersistedById(id: UUID) : Team
    fun getByName(name: String) : TeamDto
    fun create(teamDto: TeamDto) : UUID
    fun update(teamDto: TeamDto, id: UUID)
    fun findAll(pageable: Pageable) : Set<TeamDto>
}