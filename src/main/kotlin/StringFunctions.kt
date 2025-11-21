package com.circleci

import java.util.Locale

object StringFunctions {
    fun reverse(s: String): String = s.reversed()
    fun capitalize(s: String): String {
        return s.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    }
}