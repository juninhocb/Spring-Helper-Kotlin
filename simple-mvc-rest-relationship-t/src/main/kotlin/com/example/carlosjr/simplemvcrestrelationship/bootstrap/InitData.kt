package com.example.carlosjr.simplemvcrestrelationship.bootstrap

import com.example.carlosjr.simplemvcrestrelationship.entities.Student
import com.example.carlosjr.simplemvcrestrelationship.entities.Subject
import com.example.carlosjr.simplemvcrestrelationship.entities.Teacher
import com.example.carlosjr.simplemvcrestrelationship.repositories.StudentRepository
import com.example.carlosjr.simplemvcrestrelationship.repositories.SubjectRepository
import com.example.carlosjr.simplemvcrestrelationship.repositories.TeacherRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class InitData(private val teacherRepository: TeacherRepository,
               private val studentRepository: StudentRepository,
               private val subjectRepository: SubjectRepository) : CommandLineRunner{
    override fun run(vararg args: String?) {

        val tea = Teacher("John Green", 15)
        val stu = Student("James Red", 5)
        val sub = Subject("Physics")

        val persistedSubject =  subjectRepository.save(sub)
        stu.subject = persistedSubject
        studentRepository.save(stu)
        tea.subject = persistedSubject
        teacherRepository.save(tea)

    }
}