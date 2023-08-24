package com.example.carlosjr.simplemvcrestrelationship.entities

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
data class Subject(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
        @CreationTimestamp @Column(name = "created_time") val createdTime: LocalDateTime? = null,
        @Column(unique = true) var name: String
) {
    constructor() : this(name = "")
    constructor(name: String) : this(null, null, name = name)
}
