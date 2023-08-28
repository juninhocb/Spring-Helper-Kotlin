package com.example.games.messaging

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SendMessage(private val rabbitTemplate: RabbitTemplate) : CommandLineRunner {
    override fun run(vararg args: String?) {
        println("Sending message...")
        rabbitTemplate.convertAndSend("game-exchange", "foo.bar.baz", "Hello from RabbitMQ!")
    }
}