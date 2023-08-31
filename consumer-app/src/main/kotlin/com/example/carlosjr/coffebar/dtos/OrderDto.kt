package com.example.carlosjr.coffebar.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import java.util.*

data class OrderDto(
    @JsonProperty("attendant_id")
    val attendantId: UUID,
    @JsonProperty("chef_id")
    var chefId : UUID? = null,
    val amount: BigDecimal
)
