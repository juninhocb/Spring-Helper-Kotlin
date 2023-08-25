package com.example.carlosjr.simplemvcrestrelationship.mappers

interface GenericMapper<T,V> {
    fun dtoToEntity(dto: T?) : V?
    fun entityToDto(entity: V?) : T?
}