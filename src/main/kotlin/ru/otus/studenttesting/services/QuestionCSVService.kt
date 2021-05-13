package ru.otus.studenttesting.services

import ru.otus.studenttesting.models.Question

interface QuestionCSVService {

    fun getQuestions() : List<Question>
}