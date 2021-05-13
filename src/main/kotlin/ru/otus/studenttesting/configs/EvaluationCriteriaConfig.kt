package ru.otus.studenttesting.configs

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "evaluation.criteria")
data class EvaluationCriteriaConfig(
    val a: Int = 0,
    val b: Int = 0,
    val c: Int = 0,
)