package ru.otus.studenttesting.dao

import com.opencsv.CSVReader
import org.springframework.stereotype.Repository
import ru.otus.studenttesting.models.Answer
import ru.otus.studenttesting.models.Question
import ru.otus.studenttesting.configs.CSVFileConfig
import java.io.FileReader

@Repository
class QuestionCSVDaoImpl(private val csvFileConfig: CSVFileConfig) : QuestionCSVDao {

    override fun getQuestions(): List<Question> {
        QuestionCSVDaoImpl::class.java.classLoader.getResourceAsStream("questions.csv")
        val reader = CSVReader(
            FileReader(csvFileConfig.path), // не заработало ни с каких углов
            ',', '"', 1
        )

        var nextLine: Array<String>?
        val questions = mutableListOf<Question>()
        while (reader.readNext().also { nextLine = it } != null) {
            if (nextLine != null) {
                questions.add(
                    Question(
                        nextLine!![0].toInt(),
                        nextLine!![1].trim(),
                        buildAnswers(nextLine!![2].trim().split(";")),
                        Answer(nextLine!![3].trim())
                    )
                )
            }
        }

        return questions
    }

    private fun buildAnswers(answers: List<String>): List<Answer> {
        val result = mutableListOf<Answer>()
        answers.forEach { result.add(Answer(it)) }

        return result
    }
}