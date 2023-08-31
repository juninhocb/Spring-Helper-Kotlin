package com.example.carlosjr.consumerapp.chef

import com.example.carlosjr.coffebar.dtos.ChefDto
import java.util.*

interface ChefService {

    fun getById (uuid: UUID) : ChefDto
    fun create (chefDto: ChefDto) : UUID
    fun getAvailable() : UUID?

}