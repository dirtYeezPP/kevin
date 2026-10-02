package org.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Task(val name: String, val description: String, val priority: Priority, val time: String)

@Serializable
enum class Priority { Low, Medium, High, Vital }
