package com.example.carlosjr.paymentproject.sm

import com.example.carlosjr.paymentproject.payment.PaymentEvent
import com.example.carlosjr.paymentproject.payment.PaymentState
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.statemachine.config.EnableStateMachineFactory
import org.springframework.statemachine.config.StateMachineConfigurerAdapter
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer
import org.springframework.statemachine.listener.StateMachineListener
import org.springframework.statemachine.listener.StateMachineListenerAdapter
import org.springframework.statemachine.state.State
import java.util.*

@Configuration
@EnableStateMachineFactory
class StateMachineConfig : StateMachineConfigurerAdapter<PaymentState, PaymentEvent>() {

    override fun configure(config: StateMachineConfigurationConfigurer<PaymentState, PaymentEvent>?) {
        config
            ?.withConfiguration()
                ?.autoStartup(true)
                    ?.listener(listener())
    }

    override fun configure(states: StateMachineStateConfigurer<PaymentState, PaymentEvent>?) {
        states?.withStates()
            ?.initial(PaymentState.NEW)
            ?.states(EnumSet.allOf(PaymentState::class.java))
            ?.end(PaymentState.AUTH)
            ?.end(PaymentState.PRE_AUTH)
            ?.end(PaymentState.AUTH_ERROR)
    }

    override fun configure(transitions: StateMachineTransitionConfigurer<PaymentState, PaymentEvent>?) {
        transitions?.withExternal()
            ?.source(PaymentState.NEW)
            ?.target(PaymentState.NEW)
            ?.event(PaymentEvent.PRE_AUTHORIZE)
            ?.and()
            ?.withExternal()
            ?.source(PaymentState.NEW)
            ?.target(PaymentState.PRE_AUTH)
            ?.event(PaymentEvent.PRE_AUTH_APPROVED)
            ?.and()
            ?.withExternal()
            ?.source(PaymentState.NEW)
            ?.target(PaymentState.PRE_AUTH_ERROR)
            ?.event(PaymentEvent.AUTH_DECLINED)
    }


    @Bean
    fun listener(): StateMachineListener<PaymentState, PaymentEvent> {
        return object : StateMachineListenerAdapter<PaymentState, PaymentEvent>() {
            override fun stateChanged(from: State<PaymentState, PaymentEvent>?,
                                      to: State<PaymentState, PaymentEvent>?) {
                println("State changed ($from to $to)")
            }
        }
    }




}