package com.example.subscribe.messaging

import com.example.common.dto.ChampionshipDto
import com.example.common.dto.EnrollmentDto
import com.example.common.dto.GameProcessDto
import com.example.common.dto.SubscribeResponseDto
import com.example.subscribe.enrollment.EnrollmentService
import org.springframework.stereotype.Component

@Component
class GameMessagingQueueHandler(private val service: EnrollmentService,
                                private val rabbitSender: SendMessage) {



    fun messageProcessor(gameProcessDto: GameProcessDto) {

        Thread.sleep(1000)

        val response =  SubscribeResponseDto(gameProcessDto.id)

        println("[2] Message received ${gameProcessDto.gameDto.team} ")

        try {

            val enrolmentToValidate = EnrollmentDto(
                teamName = gameProcessDto.gameDto.team,
                championship = ChampionshipDto(
                    name = gameProcessDto.gameDto.championship
                )
            )

            //others services...
            val isVerified = service.verifyTeamEnrollment(enrolmentToValidate)

            if (isVerified) {

                println("[2] Verify approved")
                response.approved = true
                response.error = false
                response.validatedGameDto = gameProcessDto.gameDto

            } else {
                println("[2] Verify not approved")
                response.approved = false
                response.error = false
                response.validatedGameDto = gameProcessDto.gameDto
            }

        }  catch (ex: Exception){
            println("[2] Problem ${ex.message}")
            response.approved = false
            response.error = true
        }

        rabbitSender.exchangeMessage(response)

    }

}