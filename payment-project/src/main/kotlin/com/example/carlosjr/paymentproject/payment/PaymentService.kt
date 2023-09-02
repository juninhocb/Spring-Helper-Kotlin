package com.example.carlosjr.paymentproject.payment

import org.springframework.statemachine.StateMachine

interface PaymentService {

    fun newPayment(payment: Payment) : Payment

    fun preAuth(paymentId: Long) : StateMachine<PaymentState, PaymentEvent>

    fun authorizePayment(paymentId: Long) : StateMachine<PaymentState, PaymentEvent>

    fun declineAuth(paymentId: Long) : StateMachine<PaymentState, PaymentEvent>

}