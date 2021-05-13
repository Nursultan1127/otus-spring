package ru.otus.studenttesting.shell

import org.springframework.shell.Availability
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellMethodAvailability
import org.springframework.shell.standard.ShellOption
import ru.otus.studenttesting.services.AuthorizationService
import ru.otus.studenttesting.services.QuestionCSVService
import ru.otus.studenttesting.services.SummarizeResultService
import ru.otus.studenttesting.services.TestingService

@ShellComponent
class CompleteTestProcessCommands(
    private val authorizationService: AuthorizationService,
    private val questionCSVService: QuestionCSVService,
    private val testingService: TestingService,
    private val summarizeResultService: SummarizeResultService
) {
    private var userName: String? = null

    @ShellMethod(value = "Authorizing command", key = ["a", "authorize"])
    fun authorize(@ShellOption(defaultValue = "user") userName: String): String {
        this.userName = authorizationService.authorize()
        return "Welcome ${this.userName}"
    }

    @ShellMethod(value = "Complete testing command", key = ["t", "test"])
    @ShellMethodAvailability(value = ["isCompleteTestProcessCommandAvailable"])
    fun completeTestProcess() {
        val result = testingService.testStudent(questionCSVService.getQuestions())
        println(summarizeResultService.summarizeResult(result))
    }


    private fun isCompleteTestProcessCommandAvailable(): Availability? {
        return if (userName == null) Availability.unavailable("Сначала залогиньтесь") else Availability.available()
    }
}