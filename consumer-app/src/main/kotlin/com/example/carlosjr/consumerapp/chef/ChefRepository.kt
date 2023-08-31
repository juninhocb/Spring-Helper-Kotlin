package com.example.carlosjr.consumerapp.chef

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ChefRepository : JpaRepository<Chef, UUID> {

    fun findChefByIsAvailableTrueOrderByQuantityOnHandAsc() : List<Chef>

}