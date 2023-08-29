package com.example.games.game

import com.example.common.dto.GameDto
import com.example.games.messaging.SendMessage
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/games/game")
class GameResource(private val service: GameService,
                   private val message: SendMessage) {

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


    //sync approach
    /*@PostMapping
    fun createGame(@RequestBody @Valid gameDto: GameDto,
                   ucb: UriComponentsBuilder) : ResponseEntity<Void> {

        val persistedId = service.create(gameDto)

        val resourcePath: URI =
            ucb
                .path("/api/v1/games/game/{id}")
                .buildAndExpand(persistedId)
                .toUri()

        return ResponseEntity.created(resourcePath).build()
    }*/

    @PostMapping
    fun createGame(@RequestBody @Valid gameDto: GameDto) : ResponseEntity<Void>{
        gameDto.status = GameStateProcess.PROCESSING.name
        message.sendMessageToBroker(gameDto)
        return ResponseEntity.status(HttpStatus.ACCEPTED).build()
    }



}