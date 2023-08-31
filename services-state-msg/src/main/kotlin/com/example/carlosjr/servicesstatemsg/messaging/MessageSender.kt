package com.example.carlosjr.servicesstatemsg.messaging

import com.example.carlosjr.coffebar.dtos.OrderDto
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class MessageSender(private val rabbitTemplate: RabbitTemplate) {

    fun sendMessage(orderDto: OrderDto){

        println("Sending order $orderDto")

        rabbitTemplate.convertAndSend(RabbitMqConfig
            .topicExchangeName, "my.api.order", orderDto)

    }

}