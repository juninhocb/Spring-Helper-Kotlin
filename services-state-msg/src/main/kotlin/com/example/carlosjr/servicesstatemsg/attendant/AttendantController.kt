package com.example.carlosjr.servicesstatemsg.attendant

import com.example.carlosjr.coffebar.dtos.AttendantDto
import com.example.carlosjr.coffebar.dtos.OrderDto
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.util.*

@RestController
@RequestMapping("/api/v1/attendant")
class AttendantController(private val service: AttendantService) {

    @GetMapping
    fun getById(@RequestParam("id") uuid: UUID) : ResponseEntity<AttendantDto> {
        return ResponseEntity.ok(service.getById(uuid))
    }

    @PostMapping
    fun create(@RequestBody @Valid dto: AttendantDto,
               ucb: UriComponentsBuilder) : ResponseEntity<Void> {
       val savedUUID = service.create(dto)
       val resourcePath = ucb
           .path("/api/v1/attendant?id={id}")
           .buildAndExpand(savedUUID)
           .toUri()

       return ResponseEntity.created(resourcePath).build()
    }

    @PostMapping("/emmit")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun emmitOrder(@RequestBody @Valid orderDto: OrderDto) {
        service.emmitOrder(orderDto)
    }


}