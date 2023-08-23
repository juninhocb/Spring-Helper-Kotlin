package com.example.carlosjr.simplemvcrestrelationship.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
data class Teacher(override var name: String,
                   @Column(name = "career_experience") var careerExperience: Int) : BasePerson(name = name) {
    constructor() : this(name = "",  careerExperience = 0)
}
