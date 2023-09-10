package com.example.fluxfunctionalendpoints.car

import com.example.fluxfunctionalendpoints.exceptions.ResourceNotFoundException
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class CarServiceImpl(private val repository: CarRepository,
                     private val mapper: CarMapper) : CarService {

    override fun getById(id: Mono<Long>): Mono<CarDto> {
        return handleGetById(id).flatMap {
            Mono.just(mapper.entityToDto(it))
        }
    }

    override fun getAll(): Flux<CarDto> {
        return repository.findAll().flatMap {
            Mono.fromCallable { mapper.entityToDto(it) }
        }
    }

    override fun create(dto: Mono<CarDto>): Mono<Long> {
        return dto.flatMap {
            val entity = mapper.dtoToEntity(it)
            repository.save(entity)
        }.map { it.id!! }
    }

    override fun update(id: Mono<Long>, dto: Mono<CarDto>) : Mono<Void> {
        val carMono = handleGetById(id)

         return dto.flatMap { dtoNoMono ->
            carMono.flatMap {carNoMono ->
                repository.save(mapper.updateEntityFromDto(dtoNoMono, carNoMono))
            }
        }.then()
    }

    override fun delete(id: Mono<Long>){
        id.flatMap {
                handleGetById(id).flatMap { car ->
                        repository.delete(car).then()
                }
            }.subscribe()
    }


    private fun handleGetById(id: Mono<Long>) : Mono<Car> {
        return id.flatMap { idVal -> repository
            .findById(idVal)
            .flatMap { car ->
                if (car != null) {
                    Mono.just(car)
                } else {
                    Mono.error(ResourceNotFoundException(idVal))
                }
            }
        }
    }
}