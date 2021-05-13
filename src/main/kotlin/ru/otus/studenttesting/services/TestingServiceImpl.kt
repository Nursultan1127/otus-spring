package ru.otus.studenttesting.services

import org.springframework.stereotype.Service
import ru.otus.studenttesting.models.Question
import java.util.*

@Service
class TestingServiceImpl: TestingService {

    private val scan = Scanner(System.`in`)

    override fun testStudent(questions: List<Question>) : Int {
        var rightAnswers = 0
        for(i in 0 until questions.size) {
            println(questions[i].description)
            for(j in 0 until questions[i].answers.size) {
                println(questions[i].answers[j].description)
            }
            print("Enter an answer: ")
            if(checkingAnswer(questions[i], scan.nextLine())) {
                rightAnswers++
            }
            println("########################################")
        }

        return rightAnswers
    }

    private fun checkingAnswer(question: Question, answer: String) =
        question.rightAnswer.description == answer

}