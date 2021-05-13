package ru.otus.studenttesting.configs

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "csv")
data class CSVFileConfig(
     val path: String
)
