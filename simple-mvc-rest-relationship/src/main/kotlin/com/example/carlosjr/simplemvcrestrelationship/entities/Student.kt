package com.example.carlosjr.simplemvcrestrelationship.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
data class Student(override var name: String,
                   @Column(name = "average_notice") var averageNotice: Int) : BasePerson(name = name) {
    constructor() : this(name = "", averageNotice = 0)
}