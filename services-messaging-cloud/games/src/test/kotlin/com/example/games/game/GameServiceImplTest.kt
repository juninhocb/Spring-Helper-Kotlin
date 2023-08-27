package com.example.games.game

import com.example.common.dto.GameDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class GameServiceImplTest(@Autowired val gameService: GameService) {

    @Test
    fun create() {

        val persistedId = gameService.create(getObject())

        assertThat(persistedId).isNotNull()

        val gameSaved = gameService.getById(persistedId)

        assertThat(gameSaved.id).isEqualTo(persistedId)
        assertThat(gameSaved.team).isEqualTo("Palmeiras")

        println(gameSaved)

    }

    @Test
    fun getAllByChampionship() {

        gameService.create(getObject())
        gameService.create(getObject2())

        val setBrasileiraoGames = gameService
            .getAllByChampionship("Brasileirao")

        assertThat(setBrasileiraoGames.size).isEqualTo(2)

        setBrasileiraoGames.forEach { println(it) }


    }

    @Test
    fun getAllByTeam() {

        gameService.create(getObject())
        gameService.create(getObject3())

        val setPalmeirasGames = gameService
            .getAllByTeam("Palmeiras")

        assertThat(setPalmeirasGames.size).isEqualTo(2)

        setPalmeirasGames.forEach { println(it) }
    }

    private fun getObject() : GameDto {
        return GameDto(
            team = "Palmeiras",
            adversary =  "Internacional",
            championship = "Brasileirao",
            result = "WIN")
    }

    private fun getObject2() : GameDto {
        return GameDto(
            team = "Corinthians",
            adversary =  "Goias",
            championship = "Brasileirao",
            result = "DRAW")
    }

    private fun getObject3() : GameDto {
        return GameDto(
            team = "Palmeiras",
            adversary =  "Atlético Pr",
            championship = "Brasileirao",
            result = "WIN")
    }

}