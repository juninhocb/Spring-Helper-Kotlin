package com.example.carlosjr.consumerapp.order

import com.example.carlosjr.consumerapp.chef.Chef
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "orders")
data class Order(
    @Id
    @GeneratedValue
    @GenericGenerator(name = "UUID")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "VARCHAR(36)")
    val id: UUID? = null,
    @CreationTimestamp
    @Column(name = "created_at")
    val createdAt: LocalDateTime? = null,
    @Column(name = "finished_at")
    var finishedAt: LocalDateTime? = null,
    @Column(name = "attendant_id", columnDefinition = "VARCHAR(36)")
    var attendantId: UUID,
    @ManyToOne
    @JoinColumn(name = "chef_id", referencedColumnName = "id", columnDefinition = "VARCHAR(36)")
    var chef: Chef,
    var amount: BigDecimal,
    @Enumerated(EnumType.STRING)
    var result: OrderResult? = null,
    @Enumerated(EnumType.STRING)
    var state: OrderState

) {
    constructor() :
            this(null, null, null, UUID.randomUUID(), Chef(), BigDecimal(0.0), null, OrderState.INIT_PROCESS)
}
