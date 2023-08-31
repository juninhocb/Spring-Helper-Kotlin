package com.example.carlosjr.consumerapp.order

import com.example.carlosjr.coffebar.dtos.OrderDto

interface OrderService {
    fun saveOrder(orderDto: OrderDto)
}