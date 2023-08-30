package com.example.games.config

import com.example.games.game.GameEvents
import com.example.games.game.GameStateProcess
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.statemachine.StateContext
import org.springframework.statemachine.action.Action
import org.springframework.statemachine.config.EnableStateMachine
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer
import java.util.*
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter as EnumStateMachineConfigurerAdapter1

@Configuration
@EnableStateMachine
class StateMachineConfig : EnumStateMachineConfigurerAdapter1<GameStateProcess, GameEvents>() {

    override fun configure(states: StateMachineStateConfigurer<GameStateProcess, GameEvents>) {
        states.withStates()
            .initial(GameStateProcess.INIT_PROCESS)
            .end(GameStateProcess.SUCCESSFUL)
            .end(GameStateProcess.ERROR)
            .states(EnumSet.allOf(GameStateProcess::class.java))
    }

    override fun configure(transitions: StateMachineTransitionConfigurer<GameStateProcess, GameEvents>?) {
        transitions!!.withExternal()
            .source(GameStateProcess.INIT_PROCESS)
            .target(GameStateProcess.SUCCESSFUL)
            .event(GameEvents.ON_SUCCESS)
            .action(onSuccess())
            .and()
            .withExternal()
            .source(GameStateProcess.INIT_PROCESS)
            .target(GameStateProcess.ERROR)
            .event(GameEvents.ON_ERROR)
            .action(onError())
    }

    @Bean
    fun onSuccess() : Action<GameStateProcess, GameEvents> {
        return Action<GameStateProcess, GameEvents> {
            println("Change to SUCCESS!")
        }
    }

    @Bean
    fun onError() : Action<GameStateProcess, GameEvents> {
        return object : Action<GameStateProcess, GameEvents> {
            override fun execute(p0: StateContext<GameStateProcess, GameEvents>?) {
                println("Change to ERROR!")
            }
        }
    }

}