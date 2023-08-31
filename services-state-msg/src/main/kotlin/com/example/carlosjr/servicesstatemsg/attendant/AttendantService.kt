package com.example.carlosjr.servicesstatemsg.attendant

import com.example.carlosjr.coffebar.dtos.AttendantDto
import com.example.carlosjr.coffebar.dtos.OrderDto
import java.util.*

interface AttendantService {
    fun getById (uuid: UUID) : AttendantDto
    fun create (attendantDto: AttendantDto) : UUID
    fun emmitOrder (order: OrderDto)
}