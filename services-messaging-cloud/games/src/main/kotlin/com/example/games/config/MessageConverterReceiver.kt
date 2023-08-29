package com.example.games.config

import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageProperties
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.stereotype.Component
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

@Component
class MessageConverterReceiver : MessageConverter {

    override fun toMessage(p0: Any, p1: MessageProperties): Message {
        try {
            val byteArrayOutputStream = ByteArrayOutputStream()
            val objectOutputStream = ObjectOutputStream(byteArrayOutputStream)
            objectOutputStream.writeObject(p0)
            objectOutputStream.flush()
            val bytes = byteArrayOutputStream.toByteArray()
            p1.contentType = "application/x-java-serialized-object"
            p1.contentLength = bytes.size.toLong()
            return Message(bytes, p1)
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException("Failed to serialize the message", e)
        }
    }

    //application/x-java-serialized-object
    override fun fromMessage(p0: Message): Any {
        try {
            val byteArrayInputStream = ByteArrayInputStream(p0.body)
            val objectInputStream = ObjectInputStream(byteArrayInputStream)
            val deserializedObject = objectInputStream.readObject()
            return deserializedObject
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException("Failed to deserialize the message", e)
        }
    }
}