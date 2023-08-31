package com.example.carlosjr.servicesstatemsg.messaging

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageProperties
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.stereotype.Component

@Component
class ConvertObjectToQueue(private val objectMapper: ObjectMapper) : MessageConverter{

    override fun toMessage(p0: Any, p1: MessageProperties): Message {
        val objectJson = objectMapper.writeValueAsString(p0)
        val message = objectJson.toByteArray()
        p1.contentType = MessageProperties.CONTENT_TYPE_JSON
        return Message(message, p1)
    }

    override fun fromMessage(p0: Message): Any {
        TODO("Not yet implemented")
    }
}