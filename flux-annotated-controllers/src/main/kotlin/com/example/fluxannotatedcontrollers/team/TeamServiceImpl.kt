package com.example.fluxannotatedcontrollers.team

import com.example.fluxannotatedcontrollers.exceptions.ResourceNotFoundException
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TeamServiceImpl(private val repository: TeamRepository,
                      private val mapper: TeamMapper) : TeamService {

    override fun getById(id: Long): TeamDto {
        return mapper.entityToDto(handleGetById(id))
    }

    override fun getAll(pageable: Pageable): Set<TeamDto> {
        return repository
                 .findAll(pageable)
                 .map{
                     mapper.entityToDto(it)
                 }.toSet()
    }

    override fun save(teamDto: TeamDto): Long {
        val persistedTeam = repository
                              .save(mapper.dtoToEntity(teamDto))
        return persistedTeam.id!!
    }

    override fun update(id: Long, teamDto: TeamDto) {
        val persisted = handleGetById(id)
        persisted.name = teamDto.name
        persisted.titles = teamDto.titles
        repository.save(persisted)
    }

    override fun delete(id: Long) {
        repository.delete(handleGetById(id))
    }

    private fun handleGetById(id: Long) : Team{
        val teamOpt = repository.findById(id)
        if (teamOpt.isEmpty){
            throw ResourceNotFoundException(id.toString())
        }
        return teamOpt.get()
    }
}