package ru.otus.studenttesting.services

import org.springframework.stereotype.Service
import ru.otus.studenttesting.configs.EvaluationCriteriaConfig

@Service
class SummarizeResultServiceImpl(private val criteria: EvaluationCriteriaConfig) : SummarizeResultService {

    override fun summarizeResult(rightAnswers: Int) =
        when {
            rightAnswers < criteria.c -> "Unfortunately you did not pass the test"
            rightAnswers == criteria.b -> "Congratulations! You have passed the exam! Your grade is B"
            rightAnswers == criteria.a -> "Congratulations! You have passed the exam! Your grade is A"
            else -> "Something went wrong"
        }
}
