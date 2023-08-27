package com.example.games.game

import com.example.common.dto.GameDto
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/api/v1/games/game")
class GameResource(private val service: GameService) {

    @GetMapping("/{gameId}")
    fun getGameById(@PathVariable(name = "gameId") id: UUID) : ResponseEntity<GameDto> {

        return ResponseEntity.ok().body(service.getById(id))
    }

    @GetMapping("/find/championship")
    fun getAllByChampionship(@RequestParam("championship") championship: String) : ResponseEntity<Set<GameDto>> {
        return ResponseEntity.ok().body(service.getAllByChampionship(championship))
    }

    @GetMapping("/find/team")
    fun getAllByTeam(@RequestParam("team") team: String) : ResponseEntity<Set<GameDto>> {
        return ResponseEntity.ok().body(service.getAllByTeam(team))
    }

    @PostMapping
    fun createGame(@RequestBody @Valid gameDto: GameDto,
                   ucb: UriComponentsBuilder) : ResponseEntity<Void> {

        val persistedId = service.create(gameDto)

        val resourcePath: URI =
            ucb
                .path("/api/v1/games/game/{id}")
                .buildAndExpand(persistedId)
                .toUri()

        return ResponseEntity.created(resourcePath).build()
    }



}