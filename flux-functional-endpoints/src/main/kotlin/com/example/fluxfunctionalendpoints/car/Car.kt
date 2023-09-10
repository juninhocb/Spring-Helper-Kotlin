package com.example.fluxfunctionalendpoints.car

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import java.time.LocalDateTime

data class Car(
    var name: String,
    var velocity: Int,
    @Id val id: Long? =null,
    @CreatedDate
    @Column("created_at")
    val createdAt: LocalDateTime? = LocalDateTime.now()
)