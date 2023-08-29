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

        val response =  SubscribeResponseDto(gameProcessDto.id)

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

                response.approved = true
                response.error = false
                response.validatedGameDto = gameProcessDto.gameDto

            } else {

                response.approved = true
                response.error = false
                response.validatedGameDto = gameProcessDto.gameDto
            }

        }  catch (ex: Exception){
            response.approved = false
            response.error = true
        }

        rabbitSender.exchangeMessage(response)

    }

}