package ru.otus.studenttesting

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StudentTestingApplication

fun main(args: Array<String>) {
    runApplication<StudentTestingApplication>(*args)
}
