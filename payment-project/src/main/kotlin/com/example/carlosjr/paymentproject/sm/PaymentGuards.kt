package com.example.carlosjr.paymentproject.sm

import com.example.carlosjr.paymentproject.payment.PaymentEvent
import com.example.carlosjr.paymentproject.payment.PaymentServiceImpl
import com.example.carlosjr.paymentproject.payment.PaymentState
import org.springframework.statemachine.guard.Guard
import org.springframework.stereotype.Component

@Component
class PaymentGuards {

    /**
     *Ensure that payment id exists and is not null!
     */
    fun paymentIdGuard() : Guard<PaymentState, PaymentEvent> {
        return Guard{
            it.getMessageHeader(PaymentServiceImpl.PAYMENT_ID_HEADER) != null
        }
    }

}