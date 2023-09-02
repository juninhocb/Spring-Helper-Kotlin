package com.example.carlosjr.paymentproject.payment

import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/payment")
class PaymentResource(private val service: PaymentService) {

    @PutMapping("/authorize")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun authorizePayment(@RequestParam(value = "id")id: Long){
        service.authorizePayment(id)
    }

    @PostMapping("/pay")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun realizePayment(@RequestBody payment: Payment){
        service.processNewPayment(payment)
    }

}