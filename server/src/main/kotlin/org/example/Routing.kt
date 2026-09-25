package org.example

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.http.content.*
import io.ktor.server.thymeleaf.ThymeleafContent
import org.example.model.Task
import org.example.model.Priority


fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello")
        }
        get("/html-thymeleaf"){
            call.respond(ThymeleafContent("index", mapOf("user" to ThymeleafUser(1, "user1"))))
        }
        get("/tasks") {
            val tasks = listOf(
                Task("clean", "clean house", Priority.Low),
                Task("play", "play with cat", Priority.Vital),
                Task("shopping", "buy groceries", Priority.Medium)
            )
            call.respond(ThymeleafContent("all tasks", mapOf("tasks" to tasks)))
        }
        staticResources("/static", "static")
    }
}