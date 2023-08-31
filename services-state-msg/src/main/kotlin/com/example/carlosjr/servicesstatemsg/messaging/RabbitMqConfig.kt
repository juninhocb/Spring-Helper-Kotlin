package com.example.carlosjr.servicesstatemsg.messaging

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMqConfig {

    companion object {
        const val topicExchangeName = "order-exchange"
        const val queueName = "order"
    }

    @Bean
    fun queue() : Queue? {
        return Queue(queueName, false)
    }

    @Bean
    fun exchange() : TopicExchange? {
        return TopicExchange(topicExchangeName)
    }

    @Bean
    fun binding(queue: Queue?, exchange: TopicExchange?) : Binding?{
        return BindingBuilder
            .bind(queue)
            .to(exchange)
            .with("my.api.#")
    }

}