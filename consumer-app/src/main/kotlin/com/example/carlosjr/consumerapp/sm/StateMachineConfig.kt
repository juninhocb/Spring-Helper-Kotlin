package com.example.carlosjr.consumerapp.sm

import com.example.carlosjr.consumerapp.order.OrderEvents
import com.example.carlosjr.consumerapp.order.OrderState
import org.springframework.context.annotation.Configuration
import org.springframework.statemachine.config.EnableStateMachine
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer
import org.springframework.statemachine.listener.StateMachineListenerAdapter
import org.springframework.statemachine.state.State

@Configuration
@EnableStateMachine
class StateMachineConfig(private val stateMachineActions: StateMachineActions) : EnumStateMachineConfigurerAdapter<OrderState, OrderEvents>() {

    override fun configure(states: StateMachineStateConfigurer<OrderState, OrderEvents>?) {
        states!!.withStates()
            .initial(OrderState.INIT_PROCESS)
            .end(OrderState.PROCESSED)
            .states(setOf(OrderState.INIT_PROCESS, OrderState.PROCESSING, OrderState.PROCESSED))
    }

    override fun configure(transitions: StateMachineTransitionConfigurer<OrderState, OrderEvents>?) {
        transitions!!.withExternal()
            .source(OrderState.INIT_PROCESS)
            .target(OrderState.PROCESSING)
            .event(OrderEvents.ON_PROCESSING)
            .action(stateMachineActions.processing())
            .and()
            .withExternal()
            .source(OrderState.PROCESSING)
            .target(OrderState.PROCESSED)
            .event(OrderEvents.ON_SUCCESS)
            .action(stateMachineActions.onSuccess())
            .and()
            .withExternal()
            .source(OrderState.PROCESSING)
            .target(OrderState.PROCESSED)
            .event(OrderEvents.ON_ERROR)
            .action(stateMachineActions.onError())
    }

    override fun configure(config: StateMachineConfigurationConfigurer<OrderState, OrderEvents>?) {
        val adapter: StateMachineListenerAdapter<OrderState?, OrderEvents?> =
            object : StateMachineListenerAdapter<OrderState?, OrderEvents?>() {
                override fun stateChanged(
                    from: State<OrderState?, OrderEvents?>?,
                    to: State<OrderState?, OrderEvents?>?
                ) {
                    println("stateChanged(from: $from, to: $to)")
                }
            }
        config?.withConfiguration()?.listener(adapter)
    }
}




