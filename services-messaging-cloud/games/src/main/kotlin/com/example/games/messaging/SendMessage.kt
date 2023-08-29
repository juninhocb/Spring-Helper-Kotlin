package com.example.games.messaging

import com.example.common.dto.GameDto
import com.example.common.dto.GameProcessDto
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component
import java.util.*

@Component
class SendMessage(private val rabbitTemplate: RabbitTemplate) {

    fun sendMessageToBroker(gameDto: GameDto) {

        println("Sending message...")

        val gameProcessor = GameProcessDto(
            UUID.randomUUID(),
            gameDto
        )
        rabbitTemplate.convertAndSend("game-exchange", "foo.bar.baz", gameProcessor)
    }
}