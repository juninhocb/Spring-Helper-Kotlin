package com.example.common.dto

import java.io.Serializable
import java.util.*

data class GameProcessDto (
    val id: UUID,
    val gameDto: GameDto
) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 1L
    }
}
