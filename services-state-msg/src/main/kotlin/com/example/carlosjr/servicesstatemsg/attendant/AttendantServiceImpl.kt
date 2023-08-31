package com.example.carlosjr.servicesstatemsg.attendant

import com.example.carlosjr.coffebar.dtos.AttendantDto
import com.example.carlosjr.coffebar.dtos.OrderDto
import com.example.carlosjr.coffebar.exceptions.ResourceNotFoundException
import com.example.carlosjr.servicesstatemsg.messaging.MessageSender
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.*

@Service
class AttendantServiceImpl(private val repository: AttendantRepository,
                           private val mapper: AttendantMapper,
                           private val restTemplate: RestTemplate,
                           private val messageSender: MessageSender ) : AttendantService {

    override fun getById(uuid: UUID): AttendantDto {
        val attendantOpt = repository.findById(uuid)
        if (attendantOpt.isEmpty){
            throw ResourceNotFoundException(uuid.toString())
        }
        return mapper.entityToDto(attendantOpt.get())
    }

    override fun create(attendantDto: AttendantDto): UUID {
        val persistedAttendant = repository
            .save(mapper.dtoToEntity(attendantDto))
        return persistedAttendant.id!!
    }

    override fun emmitOrder(order: OrderDto) {

        if (!validate(order.attendantId)){
            throw ResourceNotFoundException("Unavailable attendant")
        }


        val request4chef = restTemplate.
                getForEntity("http://localhost:8081/api/v1/consumer/chef/requestone",
                    UUID::class.java)

        if (!request4chef.hasBody()){
            throw ResourceNotFoundException("None chef is available")
        }

        order.chefId = request4chef.body

        messageSender.sendMessage(order)

    }

    private fun validate(attendantUuid: UUID): Boolean {
        val attendantOpt = repository.findById(attendantUuid)
        return attendantOpt.isPresent
    }
}