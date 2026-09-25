val ktor_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm")
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
    implementation("io.ktor:ktor-server-thymeleaf:${ktor_version}")
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(24)
}

tasks.test {
    useJUnitPlatform()
}