package com.example.carlosjr.servicesstatemsg.attendant

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AttendantRepository : JpaRepository<Attendant, UUID> {

}