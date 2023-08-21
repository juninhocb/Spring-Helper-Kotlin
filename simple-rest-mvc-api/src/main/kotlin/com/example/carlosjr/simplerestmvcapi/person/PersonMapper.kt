package com.example.carlosjr.simplerestmvcapi.person

import com.example.carlosjr.simplerestmvcapi.person.Person
import com.example.carlosjr.simplerestmvcapi.person.PersonDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface PersonMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdTime", ignore = true)
    fun dtoToEntity(personDto: PersonDto) : Person
    fun entityToDto(person: Person) : PersonDto

}