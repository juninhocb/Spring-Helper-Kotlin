package com.example.subscribe.messaging

import com.example.common.dto.SubscribeResponseDto
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class SendMessage (private val rabbitTemplate: RabbitTemplate) {

    fun exchangeMessage(subscribeResponseDto: SubscribeResponseDto){

        rabbitTemplate.convertAndSend(subscribeResponseDto)
    }
}