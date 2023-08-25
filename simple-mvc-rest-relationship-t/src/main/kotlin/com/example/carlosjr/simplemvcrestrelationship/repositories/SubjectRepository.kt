package com.example.carlosjr.simplemvcrestrelationship.repositories

import com.example.carlosjr.simplemvcrestrelationship.entities.Subject
import org.springframework.stereotype.Repository

@Repository
interface SubjectRepository : GenericRepository<Subject>  {

}