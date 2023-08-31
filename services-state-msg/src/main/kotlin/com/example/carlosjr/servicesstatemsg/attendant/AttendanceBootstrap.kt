package com.example.carlosjr.servicesstatemsg.attendant

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class AttendanceBootstrap(private val repository: AttendantRepository) : CommandLineRunner{

    override fun run(vararg args: String?) {

        if (repository.count()  == 0L){

            val a1 = Attendant(name = "John Green")
            val a2 = Attendant(name = "Richard Brown")
            val a3 = Attendant(name = "Joana Blue")
            repository.saveAll(listOf(a1,a2,a3))

        }
    }
}