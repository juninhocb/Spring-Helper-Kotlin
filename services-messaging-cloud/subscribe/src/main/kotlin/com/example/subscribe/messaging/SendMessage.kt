package com.example.subscribe.messaging

import com.example.common.dto.SubscribeResponseDto
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class SendMessage (private val rabbitTemplate: RabbitTemplate) {

    fun exchangeMessage(subscribeResponseDto: SubscribeResponseDto){
        Thread.sleep(1000)
        println("[3] Sending to games on subscribe queue ${subscribeResponseDto.validatedGameDto?.team}")
        rabbitTemplate.convertAndSend("subscribe-exchange", "foo.bar.sla", subscribeResponseDto)
    }
}