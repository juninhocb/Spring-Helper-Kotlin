package com.example.carlosjr.paymentproject.sm

import com.example.carlosjr.paymentproject.payment.PaymentEvent
import com.example.carlosjr.paymentproject.payment.PaymentState
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.statemachine.StateMachine
import org.springframework.statemachine.config.StateMachineFactory
import java.util.*


@SpringBootTest
class StateMachineConfigTest(@Autowired private val factory: StateMachineFactory<PaymentState, PaymentEvent>){

    @Test
    fun testNewStateMachine() {

        val sm: StateMachine<PaymentState, PaymentEvent> =
            factory.getStateMachine(UUID.randomUUID())

        sm.start()
        println(sm.state)
        sm.sendEvent(PaymentEvent.PRE_AUTHORIZE)
        println(sm.state)
        sm.sendEvent(PaymentEvent.PRE_AUTH_APPROVED)
        println(sm.state)
    }
}