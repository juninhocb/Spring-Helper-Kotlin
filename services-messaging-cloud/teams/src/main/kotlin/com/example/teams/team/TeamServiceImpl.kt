package com.example.teams.team

import com.example.common.dto.TeamDto
import com.example.common.exceptions.ResourceNotFoundException
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class TeamServiceImpl(private val repository: TeamRepository,
                      private val mapper: TeamMapper) : TeamService {

    override fun getById(id: UUID): TeamDto {
        val teamOpt = repository.findById(id)
        if (teamOpt.isEmpty){
            throw ResourceNotFoundException(id.toString())
        }
        return mapper.entityToDto(teamOpt.get())
    }

    override fun getPersistedById(id: UUID): Team {
        val teamOpt = repository.findById(id)
        if (teamOpt.isEmpty){
            throw ResourceNotFoundException(id.toString())
        }
        return teamOpt.get()
    }

    override fun getByName(name: String): TeamDto {
        val teamOpt = repository.findByName(name)
        if (teamOpt.isEmpty){
            throw ResourceNotFoundException(name)
        }
        return mapper.entityToDto(teamOpt.get())
    }

    override fun create(teamDto: TeamDto): UUID {
        val persistedTeam = repository.save(mapper.dtoToEntity(teamDto))
        return persistedTeam.id!!
    }

    override fun update(teamDto: TeamDto, id: UUID) {
        val teamFromDb = getPersistedById(id)

        teamFromDb.name = teamDto.name

        repository.save(teamFromDb)

    }

    override fun findAll(pageable: Pageable): Set<TeamDto> {
        val setOfTeams = repository.findAll(pageable)
        return setOfTeams.map { mapper.entityToDto(it) }.toSet()
    }
}