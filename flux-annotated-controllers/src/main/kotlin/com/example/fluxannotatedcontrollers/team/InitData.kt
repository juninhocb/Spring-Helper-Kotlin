package com.example.fluxannotatedcontrollers.team

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Profile("test")
@Component
class InitData(private val repository: TeamRepository) : CommandLineRunner{
    override fun run(vararg args: String?) {
        val t1= Team(null, "Palmeiras", 157, null)
        val t2= Team(null, "São Paulo", 98, null)
        val t3= Team(null, "Botafogo", 72, null)
        repository.saveAll(listOf(t1,t2,t3))
    }


}