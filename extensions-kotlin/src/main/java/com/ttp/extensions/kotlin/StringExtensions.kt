package com.ttp.extensions.kotlin

fun String?.isNotNullOrEmpty() = !this.isNullOrEmpty()

fun String?.isNotNullOrBlank() = !this.isNullOrBlank()
