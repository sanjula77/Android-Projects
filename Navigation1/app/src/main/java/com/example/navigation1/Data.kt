package com.example.navigation1

import kotlinx.serialization.Serializable

@Serializable
data class Student(
    val name: String,
    val age: Int,
    val grade: String,
    val email: String
)