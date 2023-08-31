package com.example.carlosjr.consumerapp.order

import com.example.carlosjr.coffebar.dtos.OrderDto
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class OrderServiceImpl(private val mapper: OrderMapper,
                       private val repository: OrderRepository ) : OrderService {

    override fun saveOrder(orderDto: OrderDto) {

        val orderToPersist = mapper.dtoToEntity(orderDto)

        orderToPersist.finishedAt = LocalDateTime.now()

        repository.save(orderToPersist)

    }
}