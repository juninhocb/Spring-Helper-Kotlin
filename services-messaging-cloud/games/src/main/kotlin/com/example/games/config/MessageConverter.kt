package com.example.games.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageProperties
import org.springframework.amqp.support.converter.MessageConverter

//@Component
//application/json approach
class MessageConverter(private val objectMapper: ObjectMapper) : MessageConverter {

    override fun toMessage(p0: Any, p1: MessageProperties): Message {
        val json = objectMapper.writeValueAsString(p0)
        return Message(json.toByteArray(), p1)
    }

    override fun fromMessage(p0: Message): Any {
        TODO("Not yet implemented")
    }
}