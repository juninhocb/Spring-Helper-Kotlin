package com.example.games.game

import com.example.common.dto.GameDto
import org.springframework.stereotype.Component

@Component
class GameMapper {

    fun dtoToEntity(gameDto: GameDto) : Game{

        return Game(
            team = gameDto.team,
            championship = gameDto.championship,
            adversary = gameDto.adversary,
            result = GameResult.getGameResult(gameDto.result)
        )

    }

    fun entityToDto(game: Game) : GameDto {
        return GameDto(
            id = game.id,
            createdAt =  game.createdAt,
            team = game.team,
            adversary = game.adversary,
            result = game.result.toString(),
            championship = game.championship,
            status =  game.status.toString()
        )
    }

}