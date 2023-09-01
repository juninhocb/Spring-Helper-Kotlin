package com.example.carlosjr.consumerapp.sm

import com.example.carlosjr.consumerapp.order.OrderEvents
import com.example.carlosjr.consumerapp.order.OrderState
import org.springframework.context.annotation.Bean
import org.springframework.statemachine.action.Action
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class StateMachineActions() {

    @Bean
    fun processing() : Action<OrderState, OrderEvents> {

        return Action {

            if (handleOrderProcess()){


            }

        }

    }

    @Bean
    fun onSuccess() : Action<OrderState, OrderEvents> {
        TODO()
    }

    @Bean
    fun onError() : Action<OrderState, OrderEvents> {
        TODO()
    }

    private fun handleOrderProcess() : Boolean {
        val rand = Random.nextInt(5)
        return rand > 1
    }
}