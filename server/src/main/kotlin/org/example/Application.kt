package org.example

import configureThymeleaf
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    // If the tutorial had you write a configureThymeleaf() function, uncomment the next line:
    configureThymeleaf()
    configureRouting()
}