package ru.otus.studenttesting.services

import ru.otus.studenttesting.models.Question

interface TestingService {

    fun testStudent(questions: List<Question>) : Int
}