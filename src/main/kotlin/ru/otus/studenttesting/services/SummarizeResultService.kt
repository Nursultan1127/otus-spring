package ru.otus.studenttesting.services

interface SummarizeResultService {

    fun summarizeResult(rightAnswers
                        : Int) : String
}