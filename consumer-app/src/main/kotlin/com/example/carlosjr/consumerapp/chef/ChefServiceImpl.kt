package com.example.carlosjr.consumerapp.chef

import com.example.carlosjr.coffebar.dtos.ChefDto
import com.example.carlosjr.coffebar.exceptions.ResourceNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class ChefServiceImpl(private val repository: ChefRepository,
                      private val mapper: ChefMapper) : ChefService {

    override fun getById(uuid: UUID): ChefDto {
        val chefOpt = repository.findById(uuid)
        if (chefOpt.isEmpty){
            throw ResourceNotFoundException(uuid.toString())
        }
        return mapper.entityToDto(chefOpt.get())
    }

    override fun create(chefDto: ChefDto): UUID {
        val persistedChef = repository
            .save(mapper.dtoToEntity(chefDto))
        return persistedChef.id!!
    }

    override fun getAvailable(): UUID? {

        val chef = repository.findChefByIsAvailableTrueOrderByQuantityOnHandAsc()[0]

        if (chef == null){
            return null
        }

        chef.quantityOnHand ++
        repository.save(chef)
        return chef.id

    }
}