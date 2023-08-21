package com.example.carlosjr.simplerestmvcapi.person

import com.example.carlosjr.simplerestmvcapi.exceptions.ResourceNotFoundException
import org.springframework.beans.BeanUtils
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonServiceImpl(private val personRepository: PersonRepository,
                        private val personMapper: PersonMapper) : PersonService {
    override fun getRepositorySize(): Long {
        return personRepository.count()
    }

    override fun findById(id: Long): PersonDto {
        val personOpt =  personRepository.findById(id)
        if (personOpt.isEmpty)
            throw ResourceNotFoundException(id.toString())
        return personMapper.entityToDto(personOpt.get())
    }

    override fun findByName(name: String): PersonDto {
        val personOpt = personRepository.findByName(name)
        if (personOpt.isEmpty)
            throw ResourceNotFoundException(name)
        return personMapper.entityToDto(personOpt.get())
    }

    override fun findAll(pageable: Pageable): Set<PersonDto> {
        val people = personRepository.findAll(pageable)
        return people.content.map { personMapper.entityToDto(it) }.toSet()
    }

    override fun create(personDto: PersonDto): Long? {
        val persistedPerson = personRepository
            .save(personMapper.dtoToEntity(personDto))
        return persistedPerson.id
    }

    override fun createAll(people: List<PersonDto>) {
        val converted = people.map { personMapper.dtoToEntity(it) }
        personRepository.saveAll(converted)
    }

    override fun update(id: Long, personDto: PersonDto) {
        val persistedPersonOpt = personRepository.findById(id)
        if (persistedPersonOpt.isEmpty)
            throw ResourceNotFoundException(id.toString())
        val persistedPerson = persistedPersonOpt.get()
        val idBackup = persistedPerson.id
        val createBackup = persistedPerson.createdTime
        BeanUtils.copyProperties(personDto, persistedPerson)
        persistedPerson.id = idBackup
        persistedPerson.createdTime = createBackup
        personRepository.save(persistedPerson)
    }

    override fun delete(id: Long) {
        val personOptional = personRepository.findById(id)
        if (personOptional.isEmpty)
            throw ResourceNotFoundException(id.toString())
        personRepository.delete(personOptional.get())
    }
}