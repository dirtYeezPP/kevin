val ktor_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm")
    // Keep your existing kotlin("jvm") line, and add:
    kotlin("plugin.serialization") version "1.9.22" // Use the same version as your Kotlin JVM plugin

}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Notice these are the SERVER dependencies, not the client ones
    implementation("io.ktor:ktor-server-core:${ktor_version}")
    implementation("io.ktor:ktor-server-netty:${ktor_version}")
    implementation("ch.qos.logback:logback-classic:${logback_version}")
    implementation("io.ktor:ktor-server-content-negotiation:${ktor_version}")
    implementation("io.ktor:ktor-serialization-kotlinx-json:${ktor_version}")
    implementation("io.ktor:ktor-server-cors:${ktor_version}")
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(24)
}

tasks.test {
    useJUnitPlatform()
}