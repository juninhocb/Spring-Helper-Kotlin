package com.example.carlosjr.consumerapp.order

import com.example.carlosjr.coffebar.dtos.OrderDto
import com.example.carlosjr.coffebar.exceptions.ResourceNotFoundException
import com.example.carlosjr.consumerapp.chef.ChefRepository
import org.springframework.stereotype.Component

@Component
class OrderMapper(private val chefRepository: ChefRepository) {

    fun dtoToEntity(dto: OrderDto) : Order {

        val persistedChef = chefRepository.findById(dto.chefId!!)

        if (persistedChef.isEmpty){
            throw ResourceNotFoundException(dto.chefId.toString())
        }

        return Order(
            attendantId = dto.attendantId,
            chef = persistedChef.get(),
            amount = dto.amount
        )
    }

    fun entityToDto(entity: Order) : OrderDto{

        return OrderDto(
            attendantId = entity.attendantId,
            chefId = entity.chef.id,
            amount = entity.amount
        )
    }

}