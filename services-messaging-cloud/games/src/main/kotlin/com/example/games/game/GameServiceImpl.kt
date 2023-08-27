package com.example.games.game

import com.example.common.dto.GameDto
import com.example.common.exceptions.ResourceNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class GameServiceImpl(private val gameRepository: GameRepository,
                      private val gameMapper: GameMapper) : GameService {

    override fun getById(id: UUID): GameDto {

        val gameOpt = gameRepository.findById(id)

        if (gameOpt.isEmpty){
            throw ResourceNotFoundException(id.toString())
        }

        return gameMapper.entityToDto(gameOpt.get())

    }

    override fun create(gameDto: GameDto): UUID {

        val persistedGame = gameRepository.save(gameMapper.dtoToEntity(gameDto))

        return persistedGame.id!!

    }

    override fun getAllByChampionship(championship: String): Set<GameDto> {
        return gameRepository
            .findGamesByChampionship(championship)
            .map { gameMapper.entityToDto(it) }
            .toSet()
    }

    override fun getAllByTeam(team: String): Set<GameDto> {
        return gameRepository
            .findGamesByTeam(team)
            .map { gameMapper.entityToDto(it) }
            .toSet()
    }
}