package com.example.games.messaging

import org.springframework.stereotype.Component

@Component
class ReceiverMessage {

    fun receiveMessage(message: String) {
        println("Received message $message")
    }

}