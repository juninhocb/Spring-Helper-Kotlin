package com.example.subscribe.championship

import com.example.common.dto.ChampionshipDto
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.util.*

@RestController
@RequestMapping("/api/v1/subscribe/championship")
class ChampionshipResource(private val service: ChampionshipService) {

    @GetMapping("/{championshipId}")
    fun getById(@PathVariable championshipId: UUID) : ResponseEntity<ChampionshipDto> {
        return ResponseEntity.ok().body(service.getById(championshipId))
    }

    @GetMapping("/find")
    fun getByName(@RequestParam(name = "name") name: String) : ResponseEntity<ChampionshipDto> {
        return ResponseEntity.ok().body(service.getByName(name))
    }

    @PostMapping
    fun create(@RequestBody @Valid championshipDto: ChampionshipDto,
               ucb: UriComponentsBuilder
    ) : ResponseEntity<Void> {

        val resourceId = service.create(championshipDto)

        val resourceUri =
            ucb
                .path("/api/v1/subscribe/championship/{id}")
                .buildAndExpand(resourceId)
                .toUri()

        return ResponseEntity.created(resourceUri).build()
    }
}