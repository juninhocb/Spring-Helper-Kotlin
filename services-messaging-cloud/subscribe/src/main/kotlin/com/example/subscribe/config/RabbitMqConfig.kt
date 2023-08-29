package com.example.subscribe.config

import com.example.subscribe.messaging.GameMessagingQueueHandler
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
class RabbitMqConfig(private val converter: MessageConverterReceiver) {

    val topicExchangeName = "subscribe-exchange"
    val queueResponseName = "subscribe"
    val queueName = "game"

    //sender
    @Bean
    fun queue(): Queue? {
        return Queue(queueResponseName, false)
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
    fun listenerAdapter(receiver: GameMessagingQueueHandler?)
                    : MessageListenerAdapter? {
        val messageListenerAdapter = MessageListenerAdapter()
        messageListenerAdapter.setDefaultListenerMethod("messageProcessor")
        messageListenerAdapter.setDelegate(receiver)
        messageListenerAdapter.setMessageConverter(converter)
        return messageListenerAdapter
    }

    @Bean
    fun container(
        connectionFactory: ConnectionFactory?,
        listenerAdapter: MessageListenerAdapter?
    ): SimpleMessageListenerContainer? {

        val container = SimpleMessageListenerContainer()
        container.connectionFactory = connectionFactory!!
        container.setQueueNames(queueName)
        container.setMessageListener(listenerAdapter!!)
        return container
    }

}