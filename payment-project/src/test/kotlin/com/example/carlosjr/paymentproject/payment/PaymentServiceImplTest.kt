package com.example.carlosjr.paymentproject.payment

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.math.BigDecimal

@SpringBootTest
class PaymentServiceImplTest(@Autowired private val service: PaymentService,
                             @Autowired private val repository: PaymentRepository) {

    val payment = Payment()

    @BeforeEach
    fun setUp() {
        payment.amount = BigDecimal(5.0)
    }

    @Test
    fun preAuth() {
        val savedPayment = service.newPayment(payment)
        val id = savedPayment.id!!
        val sm = service.preAuth(id)
        val preAuthedPayment = repository.findById(id)
        println(preAuthedPayment.get())
        println(sm.state)
    }

    @Test
    fun authTest() {
        val savedPayment = service.newPayment(payment)
        val id = savedPayment.id!!
        val sm = service.preAuth(id)
        val preAuthedPayment = repository.findById(id)
        println(preAuthedPayment.get())
        println("PreAuth state result: ${sm.state}")

        if (sm.state.id.equals(PaymentState.AUTH)){
            val sm2 = service.authorizePayment(id)
            val authPaymentResult = repository.findById(id)
            println(authPaymentResult)
            println("Auth state result ${sm2.state}")
        }

    }
}