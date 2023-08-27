package com.example.games.game

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.LocalDateTime
import java.util.*

@Entity
data class Game(

    @Id
    @GeneratedValue
    @GenericGenerator(name = "UUID")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "VARCHAR(36)")
    val id: UUID? = null,
    @CreationTimestamp
    @Column(name = "created_at")
    val createdAt: LocalDateTime? = null,
    var team: String ,
    var adversary: String,
    var result: GameResult,
    var championship: String,
    @Enumerated(EnumType.STRING)
    var status: GameStateProcess? = null
) {
    constructor() : this(null, null, "", "", GameResult.DRAW, "",GameStateProcess.INIT_PROCESS)
}
