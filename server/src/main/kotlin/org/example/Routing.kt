package org.example

import kotlinx.serialization.*
import kotlinx.serialization.json.*

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.http.content.*
import kotlinx.serialization.builtins.ListSerializer
import org.example.model.Task
import org.example.model.Priority


fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello")
        }
        get("/tasks") {
                val tasks = listOf(
                    Task("clean", "clean house", Priority.Low),
                    Task("play", "play with cat", Priority.Vital)
                )
                val tasksString = Json.encodeToString( tasks)
                call.respond(tasksString)
        }
        staticResources("/static", "static")
    }
}