package ru.otus.studenttesting.dao

import ru.otus.studenttesting.models.Question

interface QuestionCSVDao {

    fun getQuestions() : List<Question>
}