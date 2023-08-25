package com.example.carlosjr.simplemvcrestrelationship.services

import com.example.carlosjr.simplemvcrestrelationship.exceptions.ResourceNotFoundException
import com.example.carlosjr.simplemvcrestrelationship.mappers.GenericMapper
import com.example.carlosjr.simplemvcrestrelationship.repositories.GenericRepository
import java.util.*

open class GenericServiceImpl<T,V : Any>(private val repository: GenericRepository<V>,
                                         private val mapper: GenericMapper<T,V>) : GenericService<T> {
    override fun getById(id: Long): T {

        val objOpt: Optional<V> = repository.findById(id)

        if (objOpt.isEmpty){
            throw ResourceNotFoundException(id.toString())
        }
        return mapper.entityToDto(objOpt.get())!!

    }

    override fun getByName(name: String): T {

        val objOpt = repository.findByName(name)

        if (objOpt.isEmpty){
            throw ResourceNotFoundException(name)
        }

        return mapper.entityToDto(objOpt.get())!!
    }

    override fun create(objectDto: T): T {
        return  mapper.entityToDto(repository.save(mapper.dtoToEntity(objectDto)!!))!!
    }
}