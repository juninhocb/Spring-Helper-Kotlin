package com.example.carlosjr.paymentproject.payment

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity
data class Payment (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Enumerated(EnumType.STRING)
    var state: PaymentState? = PaymentState.PRE_AUTH,

    var amount: BigDecimal

){
    constructor() : this(null, PaymentState.PRE_AUTH, BigDecimal(0.0))
}