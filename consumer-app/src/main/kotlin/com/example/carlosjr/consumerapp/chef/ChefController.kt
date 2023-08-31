package com.example.carlosjr.consumerapp.chef

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/v1/consumer/chef")
class ChefController(private val service: ChefService){

    @GetMapping("/requestone")
    fun validate() : ResponseEntity<UUID?> {
        return ResponseEntity.ok(service.getAvailable())
    }

}

