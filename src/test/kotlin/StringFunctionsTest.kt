package com.circleci

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.equals.shouldBeEqual

class StringFunctionsTest : FunSpec({
    listOf(
        "akil" to "lika",
        "atul" to "luta",
        "chris" to "sirhc",
        "jacob" to "bocaj",
        "logan" to "nagol",
        "marcos" to "socram",
    ).forEach { data ->
        val input = data.first
        val expectedOutput = data.second
        test("the reverse of $input should be $expectedOutput") {
            StringFunctions.reverse(input) shouldBeEqual expectedOutput
        }
    }

    listOf(
        "akil" to "Akil",
        "atul" to "Atul",
        "chris" to "Chris",
        "jacob" to "Jacob",
        "logan" to "Logan",
        "marcos" to "Marcos"
    ).forEach { data ->
        val input = data.first
        val expectedOutput = data.second
        test("the capitalized version of $input should be $expectedOutput") {
            StringFunctions.capitalize(input) shouldBeEqual expectedOutput
        }
    }
})