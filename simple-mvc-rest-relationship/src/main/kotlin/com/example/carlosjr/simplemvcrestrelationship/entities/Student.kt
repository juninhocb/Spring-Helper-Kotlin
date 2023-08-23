package com.example.carlosjr.simplemvcrestrelationship.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class Student(override var name: String,
                   @Column(name = "average_notice") var averageNotice: Int,
                   @ManyToOne @JoinColumn(name = "subject_id", referencedColumnName = "id") var subject: Subject? = null,
) : BasePerson(name = name) {
    constructor() : this(name = "", averageNotice = 0, subject = null)
}