package com.example.subscribe.championship

import com.example.common.dto.ChampionshipDto
import com.example.common.exceptions.ResourceNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class ChampionshipServiceImpl(private val repository: ChampionshipRepository,
                              private val mapper: ChampionshipMapper  ) : ChampionshipService {


    override fun getByName(name: String): ChampionshipDto {

        val championshipOpt = repository.findByName(name)

        if (championshipOpt.isEmpty){
            throw ResourceNotFoundException(name)
        }

        return mapper.entityToDto(championshipOpt.get())
    }

    override fun getEntityByName(name: String): Championship {

        val championshipOpt = repository.findByName(name)

        if (championshipOpt.isEmpty){
            throw ResourceNotFoundException(name)
        }

        return championshipOpt.get()
    }

    override fun getById(uuid: UUID): ChampionshipDto {

        val championshipOpt = repository.findById(uuid)

        if (championshipOpt.isEmpty){
            throw ResourceNotFoundException(uuid.toString())
        }

        return mapper.entityToDto(championshipOpt.get())
    }

    override fun create(championshipDto: ChampionshipDto): UUID {

        val persistedResource = repository.save(mapper.dtoToEntity(championshipDto))

        return persistedResource.id!!
    }
}