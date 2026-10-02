package org.example

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.example.model.Priority
import org.example.model.Task

// Our temporary in-memory database
val taskStorage = mutableListOf(
    Task("clean", "clean house", Priority.Low, "10:00"),
    Task("play", "play with cat", Priority.Vital, "18:03")
)

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello")
        }

        // Send the list to your JavaScript frontend
        get("/tasks") {
            call.respond(taskStorage)
        }

        // Receive new tasks from your JavaScript frontend
        post("/tasks") {
            // Ktor automatically converts the incoming JSON back into a Kotlin Task object
            val newTask = call.receive<Task>()

            taskStorage.add(newTask)

            // Send a "201 Created" success message back to the client
            call.respond(HttpStatusCode.Created, newTask)
        }
    }
}