package com.example.carlosjr.consumerapp.chef

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class BootstrapChef(private val repository: ChefRepository) : CommandLineRunner{
    override fun run(vararg args: String?) {

        if (repository.count() == 0L){
            val c1 = Chef(name = "Dean Black",
                          isAvailable = true,
                          quantityOnHand =  5)

            val c2 = Chef(name = "Peter White",
                isAvailable = true,
                quantityOnHand =  2)

            val c3 = Chef(name = "Frank Gray",
                isAvailable = false,
                quantityOnHand =  0)

            repository.saveAll(listOf(c1,c2,c3))

        }

    }

}