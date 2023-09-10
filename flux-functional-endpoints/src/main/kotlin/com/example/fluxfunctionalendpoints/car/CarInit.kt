package com.example.fluxfunctionalendpoints.car

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class CarInit(private val repository: CarRepository) : CommandLineRunner{
    override fun run(vararg args: String?) {
        if (repository.count().block() == 0L){
            val c1 = Car("myc2", 120)
            val c2 = Car("fast", 175)
            val c3 = Car("main car", 135)
            repository.saveAll(listOf(c1,c2,c3)).subscribe()
            println("Saved..")
        }

    }
}