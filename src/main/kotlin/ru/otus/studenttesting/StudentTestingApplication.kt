package ru.otus.studenttesting

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy
import ru.otus.studenttesting.configs.CSVFileConfig
import ru.otus.studenttesting.configs.EvaluationCriteriaConfig

@EnableAspectJAutoProxy
@EnableConfigurationProperties(
    CSVFileConfig::class,
    EvaluationCriteriaConfig::class
)
@SpringBootApplication
class StudentTestingApplication

fun main(args: Array<String>) {
    val context = runApplication<StudentTestingApplication>(*args)
}
