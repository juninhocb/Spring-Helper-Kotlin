package com.example.carlosjr.paymentproject.payment

import com.example.carlosjr.paymentproject.sm.PaymentStateChangeInterceptor
import org.springframework.messaging.support.MessageBuilder
import org.springframework.statemachine.StateMachine
import org.springframework.statemachine.config.StateMachineFactory
import org.springframework.statemachine.support.DefaultStateMachineContext
import org.springframework.stereotype.Service

@Service
class PaymentServiceImpl(private val repository: PaymentRepository,
                         private val factory: StateMachineFactory<PaymentState, PaymentEvent>,
                         private val interceptor: PaymentStateChangeInterceptor) : PaymentService {

    companion object {
        const val PAYMENT_ID_HEADER: String = "payment_id"
    }


    override fun newPayment(payment: Payment): Payment {
        payment.state = PaymentState.PRE_AUTH
        return repository.save(payment)
    }

    override fun preAuth(paymentId: Long): StateMachine<PaymentState, PaymentEvent> {
        val sm = build(paymentId)
        sendEvent(paymentId, sm, PaymentEvent.PRE_AUTHORIZE)
        return sm
    }

    override fun authorizePayment(paymentId: Long): StateMachine<PaymentState, PaymentEvent> {
        val sm = build(paymentId)
        sendEvent(paymentId, sm, PaymentEvent.AUTH_APPROVED)
        return sm
    }

    override fun declineAuth(paymentId: Long): StateMachine<PaymentState, PaymentEvent> {
        val sm = build(paymentId)
        sendEvent(paymentId, sm, PaymentEvent.AUTH_DECLINED)
        return sm
    }

    private fun sendEvent(paymentId: Long,
                          sm: StateMachine<PaymentState, PaymentEvent>,
                          event: PaymentEvent) {
        val msg = MessageBuilder
            .withPayload(event)
            .setHeader(PAYMENT_ID_HEADER, paymentId)
            .build()

        //send payment id to state machine
        sm.sendEvent(msg)

    }


    //state machine from database (high cost)
    private fun build(paymentId: Long) : StateMachine<PaymentState, PaymentEvent> {

        val persistedPayment = repository.findById(paymentId)

        val sm = factory.getStateMachine(persistedPayment.get().id.toString())

        //ensure is stopped
        sm.stop()

        //restart with the previous payment state
        //setup the interceptor to intercept each changed event
        sm.stateMachineAccessor.doWithAllRegions {
            it.addStateMachineInterceptor(interceptor)
            it.resetStateMachine(DefaultStateMachineContext<PaymentState, PaymentEvent>(persistedPayment.get().state, null, null, null))
        }

        sm.start()

        return sm

    }
}