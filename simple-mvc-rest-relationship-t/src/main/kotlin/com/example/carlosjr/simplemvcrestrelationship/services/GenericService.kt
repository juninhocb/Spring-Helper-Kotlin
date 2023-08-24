package com.example.carlosjr.simplemvcrestrelationship.services

interface GenericService<T> {
    fun getById(id: Long) : T
    fun getByName(name: String) : T
    fun create(objectDto: T) : T
}