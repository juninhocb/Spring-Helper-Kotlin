package com.example.subscribe.enrollment

import com.example.subscribe.championship.Championship
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.LocalDateTime
import java.util.*

@Entity
data class Enrollment (
    @Id
    @GeneratedValue
    @GenericGenerator(name = "UUID")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "VARCHAR(36)")
    val id: UUID? = null,
    @Column(name = "team_name", unique = true)
    var teamName: String,
    @ManyToOne
    @JoinColumn(name = "championship", referencedColumnName = "name", columnDefinition = "VARCHAR(36)")
    var championship: Championship,
    @Column(name = "is_active")
    var isActive: Boolean,
    @CreationTimestamp
    @Column(name = "created_at")
    val createdAt: LocalDateTime? = null
) {
    constructor() : this(null, "", Championship(), false, null)
}