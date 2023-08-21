package com.example.carlosjr.simplerestmvcapi.person

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
data class Person (
    @Id @GeneratedValue var id: Long? = null,
    var name: String,
    var age: Int,
    @Column(name= "is_alive") var isAlive: Boolean,
    @CreationTimestamp @Column(name= "created_time") var createdTime: LocalDateTime
) {
    constructor() : this(null, "", 0, false, LocalDateTime.now())
}