package ru.otus.studenttesting.services

import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthorizationServiceImpl : AuthorizationService {

    private val scan = Scanner(System.`in`)

    override fun authorize(): String {
        print("Enter your login: ")
        return scan.nextLine()
    }
}