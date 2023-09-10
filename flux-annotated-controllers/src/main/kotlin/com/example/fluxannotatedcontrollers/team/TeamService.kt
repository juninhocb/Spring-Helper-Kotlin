package com.example.fluxannotatedcontrollers.team

import org.springframework.data.domain.Pageable


interface TeamService {
    fun getById(id: Long) : TeamDto
    fun getAll(pageable: Pageable) : Set<TeamDto>
    fun save(teamDto: TeamDto) : Long
    fun update(id: Long, teamDto: TeamDto)
    fun delete(id: Long)
}