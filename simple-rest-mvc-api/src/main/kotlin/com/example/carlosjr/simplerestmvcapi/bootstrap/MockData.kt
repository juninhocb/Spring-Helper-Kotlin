package com.example.carlosjr.simplerestmvcapi.bootstrap

import com.example.carlosjr.simplerestmvcapi.person.PersonDto
import com.example.carlosjr.simplerestmvcapi.person.PersonService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class MockData(private val personService: PersonService) : CommandLineRunner{
    override fun run(vararg args: String?) {
        if(personService.getRepositorySize() == 0L){
            personService.createAll(getDataToSave())
        }
    }

    private fun getDataToSave() : List<PersonDto>{
        val p1 = PersonDto(
            0,
            "John Green",
            25,
            true,
            LocalDateTime.now()
        )

        val p2 = PersonDto(
            0,
            "Peter Black",
            35,
            false,
            LocalDateTime.now()
        )
        val p3 = PersonDto(
            0,
            "Josh Red",
            32,
            true,
            LocalDateTime.now()
        )

        return listOf(p1,p2,p3)
    }

}