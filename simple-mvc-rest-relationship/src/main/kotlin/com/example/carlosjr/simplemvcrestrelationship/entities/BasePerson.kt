package com.example.carlosjr.simplemvcrestrelationship.entities

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@MappedSuperclass
abstract class BasePerson (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
        @CreationTimestamp @Column(name = "created_time") val createdTime: LocalDateTime? = null,
        @Column(unique = true) open var name: String
)