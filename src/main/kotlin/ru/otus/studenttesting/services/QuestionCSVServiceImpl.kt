package ru.otus.studenttesting.services

import org.springframework.stereotype.Service
import ru.otus.studenttesting.dao.QuestionCSVDao
import ru.otus.studenttesting.models.Question

@Service
class QuestionCSVServiceImpl(private val dao: QuestionCSVDao) : QuestionCSVService {

    override fun getQuestions(): List<Question> {
        return dao.getQuestions()
    }
}
