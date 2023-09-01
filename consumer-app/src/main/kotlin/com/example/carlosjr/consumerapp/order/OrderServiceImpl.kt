package com.example.carlosjr.consumerapp.order

import com.example.carlosjr.coffebar.dtos.OrderDto
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.statemachine.StateMachine
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class OrderServiceImpl(
    private val stateMachine: StateMachine<OrderState, OrderEvents>,
    private val repository: OrderRepository,
    private val mapper: OrderMapper) : OrderService {

    override fun handleOrderProcess(orderDto: OrderDto) {

        val persistOrder = mapper.dtoToEntity(orderDto)

        persistOrder.state = OrderState.INIT_PROCESS

        repository.save(persistOrder)

        stateMachine.start()

        val event: Message<OrderEvents> = MessageBuilder.withPayload(OrderEvents.ON_PROCESSING).build()

        stateMachine.sendEvent(Mono.just(event)).subscribe()

        persistOrder.state = OrderState.PROCESSING

        repository.save(persistOrder)

        stateMachine.stop()
        /*stateMachine.sendEvent(Mono.just(event))
            .publishOn(Schedulers.boundedElastic())
            .doOnComplete {
                persistOrder.finishedAt = LocalDateTime.now()
                persistOrder.state = OrderState.PROCESSED
                persistOrder.result = result
                repository.save(persistOrder)
            }
            .subscribe()*/


    }
}