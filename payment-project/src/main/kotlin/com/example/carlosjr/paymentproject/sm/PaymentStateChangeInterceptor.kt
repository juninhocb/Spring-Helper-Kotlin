package com.example.carlosjr.paymentproject.sm

import com.example.carlosjr.paymentproject.payment.PaymentEvent
import com.example.carlosjr.paymentproject.payment.PaymentRepository
import com.example.carlosjr.paymentproject.payment.PaymentServiceImpl
import com.example.carlosjr.paymentproject.payment.PaymentState
import org.springframework.messaging.Message
import org.springframework.statemachine.StateMachine
import org.springframework.statemachine.state.State
import org.springframework.statemachine.support.StateMachineInterceptorAdapter
import org.springframework.statemachine.transition.Transition
import org.springframework.stereotype.Component
import java.util.*

@Component
class PaymentStateChangeInterceptor(private val repository: PaymentRepository)
    : StateMachineInterceptorAdapter<PaymentState, PaymentEvent>() {

    override fun preStateChange(
        state: State<PaymentState, PaymentEvent>?,
        message: Message<PaymentEvent>?,
        transition: Transition<PaymentState, PaymentEvent>?,
        stateMachine: StateMachine<PaymentState, PaymentEvent>?,
        rootStateMachine: StateMachine<PaymentState, PaymentEvent>?
    ) {

        /**
         * If has a message in State machine, try to cast this message using header
         * Or get -1L.
         * Then, save the updated state of payment, into database.
         */
        message?.let {

            val paymentId = it.headers[PaymentServiceImpl.PAYMENT_ID_HEADER] as? Long ?: -1L

            if (paymentId != -1L) {
                val payment = repository.findById(paymentId).get()
                payment.state = state!!.id
                repository.save(payment)
            }

        }
    }
}