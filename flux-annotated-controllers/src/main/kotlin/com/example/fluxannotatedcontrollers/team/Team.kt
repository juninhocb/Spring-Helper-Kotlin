package com.example.fluxannotatedcontrollers.team

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
data class Team(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val titles: Int,
    @CreationTimestamp
    @Column(name = "created_time")
    val createdTime: LocalDateTime? = null
)
