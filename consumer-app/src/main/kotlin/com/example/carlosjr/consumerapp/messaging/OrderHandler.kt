package com.example.carlosjr.consumerapp.messaging

import com.example.carlosjr.coffebar.dtos.OrderDto
import com.example.carlosjr.consumerapp.order.OrderService
import org.springframework.stereotype.Component

@Component
class OrderHandler(private val service: OrderService) {

    fun orderHandler(orderDto: OrderDto){

        println("Message received $orderDto")

        service.saveOrder(orderDto)
    }

}
