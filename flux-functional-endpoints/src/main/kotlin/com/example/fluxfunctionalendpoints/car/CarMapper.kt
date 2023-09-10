package com.example.fluxfunctionalendpoints.car

import org.springframework.stereotype.Component

@Component
class CarMapper {

    fun dtoToEntity(dto: CarDto) : Car {
        return Car(
            name = dto.name,
            velocity = dto.velocity
        )
    }

    fun entityToDto(entity: Car) : CarDto {
        return CarDto(
            name = entity.name,
            velocity = entity.velocity,
            id = entity.id!!,
            createdAt = entity.createdAt!!
        )
    }

    fun updateEntityFromDto(dto : CarDto, entity: Car) : Car{
        return Car(
            id = entity.id,
            name = dto.name,
            velocity = dto.velocity,
            createdAt = entity.createdAt
        )
    }

}