package com.example.games.config

import com.example.games.game.GameEvents
import com.example.games.game.GameStateProcess
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.Message
import org.springframework.statemachine.StateContext
import org.springframework.statemachine.StateMachine
import org.springframework.statemachine.config.EnableStateMachine
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer
import org.springframework.statemachine.listener.StateMachineListener
import org.springframework.statemachine.state.State
import org.springframework.statemachine.transition.Transition

@Configuration
@EnableStateMachine
class StateMachineConfig : EnumStateMachineConfigurerAdapter<GameStateProcess, GameEvents>() {

    override fun configure(config: StateMachineConfigurationConfigurer<GameStateProcess, GameEvents>) {
        config.withConfiguration()
            .listener(listener())
    }

    override fun configure(states: StateMachineStateConfigurer<GameStateProcess, GameEvents>) {
        states.withStates()
            .initial(GameStateProcess.INIT_PROCESS)
            .end(GameStateProcess.SUCCESSFUL)
            .end(GameStateProcess.ERROR)
    }

    override fun configure(transitions: StateMachineTransitionConfigurer<GameStateProcess, GameEvents>?) {
        transitions!!.withExternal()
            .source(GameStateProcess.INIT_PROCESS)
            .target(GameStateProcess.SUCCESSFUL)
            .event(GameEvents.ON_SUCCESS)
            .and()
            .withExternal()
            .source(GameStateProcess.INIT_PROCESS)
            .target(GameStateProcess.ERROR)
            .event(GameEvents.ON_ERROR)
    }

    @Bean
    fun listener() : StateMachineListener<GameStateProcess, GameEvents> {

        return object : StateMachineListener<GameStateProcess, GameEvents> {
            override fun stateChanged(
                p0: State<GameStateProcess, GameEvents>?,
                p1: State<GameStateProcess, GameEvents>?
            ) {
                println("from $p0 to $p1")
            }

            override fun stateEntered(p0: State<GameStateProcess, GameEvents>?) {
                TODO("Not yet implemented")
            }

            override fun stateExited(p0: State<GameStateProcess, GameEvents>?) {
                TODO("Not yet implemented")
            }

            override fun eventNotAccepted(p0: Message<GameEvents>?) {
                TODO("Not yet implemented")
            }

            override fun transition(p0: Transition<GameStateProcess, GameEvents>?) {
                TODO("Not yet implemented")
            }

            override fun transitionStarted(p0: Transition<GameStateProcess, GameEvents>?) {
                TODO("Not yet implemented")
            }

            override fun transitionEnded(p0: Transition<GameStateProcess, GameEvents>?) {
                TODO("Not yet implemented")
            }

            override fun stateMachineStarted(p0: StateMachine<GameStateProcess, GameEvents>?) {
                TODO("Not yet implemented")
            }

            override fun stateMachineStopped(p0: StateMachine<GameStateProcess, GameEvents>?) {
                TODO("Not yet implemented")
            }

            override fun stateMachineError(p0: StateMachine<GameStateProcess, GameEvents>?, p1: Exception?) {
                TODO("Not yet implemented")
            }

            override fun extendedStateChanged(p0: Any?, p1: Any?) {
                TODO("Not yet implemented")
            }

            override fun stateContext(p0: StateContext<GameStateProcess, GameEvents>?) {
                TODO("Not yet implemented")
            }


        }

    }

}