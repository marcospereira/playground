import com.adarshr.gradle.testlogger.theme.ThemeType

plugins {
    application
    kotlin("jvm") version "2.2.20"
    id("io.kotest") version "6.0.7"
    id("com.adarshr.test-logger") version "4.0.0"
}

group = "com.circleci"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-framework-engine:6.0.7")
    testImplementation("io.kotest:kotest-runner-junit5:6.0.7")
    testImplementation("io.kotest:kotest-assertions-core:6.0.7")
    testImplementation("io.kotest:kotest-property:6.0.7")

    // Dependencies below were added for Renovate testing.

    // Has a patch update with no CVE
    implementation("com.squareup.okio:okio:3.16.3")

    // Has a minor update that fixes a CVE
    implementation("commons-io:commons-io:2.13.0")

    // Has a minor update with no CVE
    implementation("org.apache.commons:commons-lang3:3.18.0")

    // Has a major update with no CVE
    implementation("org.apache.lucene:lucene-core:9.12.3")

    // Has a major update with CVE
    implementation("org.springframework:spring-web:5.3.37")
}

tasks.test {
    useJUnitPlatform()
}

testlogger {
    theme = ThemeType.MOCHA
    showExceptions = true
    showStackTraces = true
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "com.circleci.MainKt"
}