package com.example.carlosjr.consumerapp.chef

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.LocalDateTime
import java.util.*

@Entity
data class Chef(
    @Id
    @GeneratedValue
    @GenericGenerator(name = "UUID")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "VARCHAR(36)")
    val id: UUID? = null,
    @CreationTimestamp
    @Column(name = "created_at")
    val createdAt: LocalDateTime? = null,
    var name: String,
    @Column(name = "available")
    var isAvailable : Boolean?,
    @Column(name = "quantity_on_hand")
    var quantityOnHand: Int
) {
    constructor() : this(null, null, "", false, 0)
}