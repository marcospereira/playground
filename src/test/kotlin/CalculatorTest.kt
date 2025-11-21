package com.circleci

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.equals.shouldBeEqual

data class Data(val numbers: List<Int>, val result: Int)

class CalculatorTest : FunSpec({
    listOf(
        Data(listOf(1, 2), 3),
        Data(listOf(1, -1), 0),
        Data(listOf(-1, -2), -3),
        Data(listOf(0, 0), 0)
    ).forEach { data ->
        test("sum of ${data.numbers} must be ${data.result}") {
            Calculator.sum(*data.numbers.toIntArray()) shouldBeEqual data.result
        }
    }
})