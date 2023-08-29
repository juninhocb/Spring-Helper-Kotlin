package com.example.games.config

import com.example.games.messaging.MessageHandler
import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MessageConfig(private val converterReceiver: MessageConverterReceiver) {

    val topicExchangeName = "game-exchange"
    val queueName = "game"
    val queueReceiver = "subscribe"

    //sender
    @Bean
    fun queue(): Queue? {
        return Queue(queueName, false)
    }

    @Bean
    fun exchange(): TopicExchange? {
        return TopicExchange(topicExchangeName)
    }

    @Bean
    fun binding(queue: Queue?, exchange: TopicExchange?): Binding? {
        return BindingBuilder
            .bind(queue)
            .to(exchange)
            .with("foo.bar.#")
    }

    //receiver
    @Bean
    fun listenerAdapter(receiver: MessageHandler?)
            : MessageListenerAdapter? {
        val messageListenerAdapter = MessageListenerAdapter()
        messageListenerAdapter.setDefaultListenerMethod("messageHandler")
        messageListenerAdapter.setDelegate(receiver)
        messageListenerAdapter.setMessageConverter(converterReceiver)
        return messageListenerAdapter
    }

    @Bean
    fun container(
        connectionFactory: ConnectionFactory?,
        listenerAdapter: MessageListenerAdapter?
    ): SimpleMessageListenerContainer? {

        val container = SimpleMessageListenerContainer()
        container.connectionFactory = connectionFactory!!
        container.setQueueNames(queueReceiver)
        container.setMessageListener(listenerAdapter!!)
        return container
    }

}