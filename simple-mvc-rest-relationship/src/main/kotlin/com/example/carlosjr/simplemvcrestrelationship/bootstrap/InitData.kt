package com.example.carlosjr.simplemvcrestrelationship.bootstrap

import com.example.carlosjr.simplemvcrestrelationship.entities.Student
import com.example.carlosjr.simplemvcrestrelationship.entities.Subject
import com.example.carlosjr.simplemvcrestrelationship.entities.Teacher
import com.example.carlosjr.simplemvcrestrelationship.mappers.TeacherMapper
import com.example.carlosjr.simplemvcrestrelationship.repositories.StudentRepository
import com.example.carlosjr.simplemvcrestrelationship.repositories.SubjectRepository
import com.example.carlosjr.simplemvcrestrelationship.repositories.TeacherRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class InitData(private val teacherRepository: TeacherRepository,
               private val studentRepository: StudentRepository,
               private val subjectRepository: SubjectRepository,
               private val teacherMapper: TeacherMapper ) : CommandLineRunner{
    override fun run(vararg args: String?) {

        val tea = Teacher("John Green", 15)
        val stu = Student("James Red", 5)
        val sub = Subject("Physics")

        teacherRepository.save(tea)
        studentRepository.save(stu)
        subjectRepository.save(sub)


    }
}