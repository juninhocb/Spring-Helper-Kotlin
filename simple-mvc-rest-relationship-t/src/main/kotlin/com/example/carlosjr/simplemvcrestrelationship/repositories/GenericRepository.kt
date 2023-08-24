package com.example.carlosjr.simplemvcrestrelationship.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import java.util.*

@NoRepositoryBean
interface GenericRepository<V> : JpaRepository<V, Long> {
    fun findByName(name: String) : Optional<V>

}