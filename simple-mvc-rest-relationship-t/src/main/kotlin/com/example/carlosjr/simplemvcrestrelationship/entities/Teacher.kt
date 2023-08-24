package com.example.carlosjr.simplemvcrestrelationship.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class Teacher(override var name: String,
                   @Column(name = "career_experience") var careerExperience: Int,
                   @ManyToOne @JoinColumn(name = "subject_id", referencedColumnName = "id") var subject: Subject? = null) : BasePerson(name = name) {
    constructor() : this(name = "",  careerExperience = 0, null)
}
