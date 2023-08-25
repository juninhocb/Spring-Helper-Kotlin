package com.example.subscribe.championship

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
data class Championship(
    @Id
    @GeneratedValue
    @GenericGenerator(name = "UUID")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "VARCHAR(36)")
    val id: UUID? = null,
    @Column(unique = true)
    var name: String,
    @CreationTimestamp
    @Column(name = "created_at")
    val createdAt: LocalDateTime? = null
) {
    constructor() : this(null, "", null)
}