package com.example.carlosjr.consumerapp.messaging

import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMqConfig(private val messageConverter: ConverterFromQueue) {

    val queueName = "order"

    @Bean
    fun listenerAdapter(receiver: OrderHandler?) : MessageListenerAdapter?{

        val messageListenerAdapter = MessageListenerAdapter()
        messageListenerAdapter.setDelegate(receiver)
        messageListenerAdapter.setDefaultListenerMethod("orderHandler")
        messageListenerAdapter.setMessageConverter(messageConverter)
        return messageListenerAdapter
    }

    @Bean
    fun container(connectionFactory: ConnectionFactory?,
                  listenerAdapter: MessageListenerAdapter?)
                      : SimpleMessageListenerContainer?{

        val container = SimpleMessageListenerContainer()
        container.connectionFactory = connectionFactory!!
        container.setQueueNames(queueName)
        container.setMessageListener(listenerAdapter!!)
        return container
    }

}