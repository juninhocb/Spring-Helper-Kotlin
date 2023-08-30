package com.example.games.config

import com.example.games.game.GameEvents
import com.example.games.game.GameStateProcess
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.statemachine.StateMachine


@SpringBootTest
class StateMachineConfigTest (@Autowired val sm: StateMachine<GameStateProcess, GameEvents>){


    @Test
    fun testStateMachine() {


        sm.start()

        sm.sendEvent(GameEvents.ON_ERROR)

        println(sm.state)

    }
}