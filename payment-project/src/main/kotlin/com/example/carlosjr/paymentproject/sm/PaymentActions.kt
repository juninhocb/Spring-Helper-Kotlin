package com.example.carlosjr.paymentproject.sm

import com.example.carlosjr.paymentproject.payment.PaymentEvent
import com.example.carlosjr.paymentproject.payment.PaymentServiceImpl
import com.example.carlosjr.paymentproject.payment.PaymentState
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.statemachine.StateContext
import org.springframework.statemachine.action.Action
import org.springframework.stereotype.Component
import java.util.Random

@Component
class PaymentActions {

    fun preAuthAction() : Action<PaymentState, PaymentEvent> {
        return Action {

            println("PreAuth process start!")

            val randomValue = Random().nextInt(5)

            if (randomValue > 1){
                println("PreAuth approved!")
                it.stateMachine.sendEvent(getMessage(it, PaymentEvent.PRE_AUTH_APPROVED))
            } else {
                println("PreAuth declined!")
                it.stateMachine.sendEvent(getMessage(it, PaymentEvent.PRE_AUTH_DECLINED))
            }
        }

    }

    private fun getMessage(context: StateContext<PaymentState, PaymentEvent>,
                           payload: PaymentEvent ) : Message<PaymentEvent> {

        val idFromHeader = context.getMessageHeader(PaymentServiceImpl.PAYMENT_ID_HEADER)

        println("Payment id: $idFromHeader")

        val message = MessageBuilder
            .withPayload(payload)
            .setHeader(PaymentServiceImpl.PAYMENT_ID_HEADER, idFromHeader)
            .build()

        return message
    }

}