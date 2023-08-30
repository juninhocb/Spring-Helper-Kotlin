package com.example.games.messaging

import com.example.common.dto.SubscribeResponseDto
import com.example.games.game.GameEvents
import com.example.games.game.GameService
import com.example.games.game.GameStateProcess
import org.springframework.statemachine.StateMachine
import org.springframework.stereotype.Component

@Component
class MessageHandler(private val service: GameService,
                    private val stateMachine: StateMachine<GameStateProcess, GameEvents>) {

    fun messageHandler(subscribeResponseDto: SubscribeResponseDto){

        Thread.sleep(1000)

        println("[4] Message received ${subscribeResponseDto.validatedGameDto?.team}")

        stateMachine.start()

        //change to update after state machine impl
        if (subscribeResponseDto.approved){
            subscribeResponseDto.validatedGameDto?.status = GameStateProcess.SUCCESSFUL.name
            stateMachine.sendEvent(GameEvents.ON_SUCCESS)
            service.create(subscribeResponseDto.validatedGameDto!!)
        } else {
            subscribeResponseDto.validatedGameDto?.status = GameStateProcess.ERROR.name
            stateMachine.sendEvent(GameEvents.ON_ERROR)
            service.create(subscribeResponseDto.validatedGameDto!!)
        }

    }

}