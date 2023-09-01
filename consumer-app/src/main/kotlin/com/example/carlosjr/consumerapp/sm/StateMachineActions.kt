package com.example.carlosjr.consumerapp.sm

import com.example.carlosjr.consumerapp.order.OrderEvents
import com.example.carlosjr.consumerapp.order.OrderState
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.statemachine.StateContext
import org.springframework.statemachine.action.Action
import reactor.core.publisher.Mono
import kotlin.random.Random

@Configuration
class StateMachineActions() {

    @Bean
    fun processing() : Action<OrderState, OrderEvents> {
        println("Hello.!")
        Thread.sleep(2000)
        return Action {
            if (handleOrderProcess()){
                sendMessageToSm(it, OrderEvents.ON_SUCCESS)
            }else {
                sendMessageToSm(it, OrderEvents.ON_ERROR)
            }
        }
    }

    @Bean
    fun onSuccess() : Action<OrderState, OrderEvents> {
        return Action {
            println("Success")
        }
    }

    @Bean
    fun onError() : Action<OrderState, OrderEvents> {
        return Action {
            println("Error")
        }
    }

    //send to state machine new event
    private fun sendMessageToSm(context: StateContext<OrderState, OrderEvents>,
                                event: OrderEvents){

        val message : Mono<Message<OrderEvents>> =
            Mono.just(MessageBuilder.withPayload(event).build())

        context.stateMachine.sendEvent(message).subscribe()
    }

    //simulate if chef finish successfully your task
    private fun handleOrderProcess() : Boolean {
        val rand = Random.nextInt(5)
        return rand > 1
    }
}