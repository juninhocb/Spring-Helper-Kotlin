package com.example.games.messaging

import com.example.common.dto.SubscribeResponseDto
import com.example.games.game.GameService
import com.example.games.game.GameStateProcess
import org.springframework.stereotype.Component

@Component
class MessageHandler(private val service: GameService) {

    fun messageHandler(subscribeResponseDto: SubscribeResponseDto){

        //change to update after state machine impl
        if (subscribeResponseDto.approved){
            subscribeResponseDto.validatedGameDto?.status = GameStateProcess.SUCCESSFUL.name
            service.create(subscribeResponseDto.validatedGameDto!!)
        } else {
            subscribeResponseDto.validatedGameDto?.status = GameStateProcess.ERROR.name
            service.create(subscribeResponseDto.validatedGameDto!!)
        }

    }

}