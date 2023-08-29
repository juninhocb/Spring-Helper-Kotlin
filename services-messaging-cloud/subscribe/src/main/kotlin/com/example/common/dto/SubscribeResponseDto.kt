package com.example.common.dto

import java.io.Serializable
import java.util.*

data class SubscribeResponseDto(
    val id: UUID,
    var approved: Boolean,
    var error: Boolean,
    var validatedGameDto: GameDto?,
    val requestId: UUID
) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 1L
    }

    constructor(requestId: UUID)
            : this (UUID.randomUUID(), false, true, null, requestId)
}
