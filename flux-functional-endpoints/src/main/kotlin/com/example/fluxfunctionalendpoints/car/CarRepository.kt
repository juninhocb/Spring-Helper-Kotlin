package com.example.fluxfunctionalendpoints.car

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface CarRepository : ReactiveCrudRepository<Car, Long> {
}