package com.example.carlosjr.consumerapp.messaging

import com.example.carlosjr.coffebar.dtos.OrderDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageProperties
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.stereotype.Component

@Component
class ConverterFromQueue(private val objectMapper: ObjectMapper) : MessageConverter{

    override fun toMessage(p0: Any, p1: MessageProperties): Message {
        TODO("Not yet implemented")
    }

    override fun fromMessage(p0: Message): OrderDto {
        return objectMapper.readValue(p0.body, OrderDto::class.java)
    }


}
