package com.circleci

import java.io.File
import java.io.FileNotFoundException

@Throws(FileNotFoundException::class)
fun stepRerun() {
    val file = File(System.getProperty("user.home"),  "pass.txt")
    if (file.exists()) {
        println("All good. File ${file.absolutePath} already exists.")
    } else {
        file.writer().use { it.write(1) }
        throw FileNotFoundException("File ${file.absolutePath} was not generated yet")
    }
}

@Throws(IllegalStateException::class)
fun workflowRerun() {
    val buildNumber = System.getenv("CIRCLE_BUILD_NUM").toInt()
    if (buildNumber % 3 == 0) {
        println("All good. The build number ($buildNumber) is a multiple of 3")
    } else {
        throw IllegalStateException("The build number (${buildNumber}) is not a multiple of 3")
    }
}

fun main(args: Array<String>) {
    val method = args.firstOrNull()
    when (method) {
        "stepRerun" -> stepRerun()
        "workflowRerun" -> workflowRerun()
        else -> throw IllegalArgumentException("Method '${method}' not found.")
    }
}