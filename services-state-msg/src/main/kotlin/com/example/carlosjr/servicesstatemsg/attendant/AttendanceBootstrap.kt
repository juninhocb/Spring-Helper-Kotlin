package com.example.carlosjr.servicesstatemsg.attendant

import com.example.carlosjr.coffebar.dtos.OrderDto
import com.example.carlosjr.servicesstatemsg.messaging.RabbitMqConfig
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.math.BigDecimal
import java.util.*

@Component
class AttendanceBootstrap(private val repository: AttendantRepository,
                          private val rabbitTemplate: RabbitTemplate) : CommandLineRunner{

    override fun run(vararg args: String?) {

        if (repository.count()  == 0L){

            val a1 = Attendant(name = "John Green")
            val a2 = Attendant(name = "Richard Brown")
            val a3 = Attendant(name = "Joana Blue")
            repository.saveAll(listOf(a1,a2,a3))

        }

        //send Message to trigger listener...
        val dto = OrderDto(
            attendantId = repository.findAll()[0].id!!,
            chefId = UUID.fromString("291ea75d-8f50-44e5-a305-4c750dae21da"),
            amount = BigDecimal(0.0)
        )
        rabbitTemplate.convertAndSend(RabbitMqConfig.topicExchangeName, "my.api.stub", dto)
    }
}