package com.example.carlosjr.consumerapp.chef

import com.example.carlosjr.coffebar.dtos.ChefDto
import org.springframework.stereotype.Component

@Component
class ChefMapper {

    fun dtoToEntity(dto: ChefDto) : Chef{
        return Chef(
            name = dto.name,
            isAvailable = dto.isAvailable,
            quantityOnHand = dto.quantityOnHand
        )
    }

    fun entityToDto(entity: Chef) : ChefDto{
        return ChefDto(
            id = entity.id,
            createdAt = entity.createdAt,
            name = entity.name,
            isAvailable = entity.isAvailable,
            quantityOnHand = entity.quantityOnHand
        )

    }

}

