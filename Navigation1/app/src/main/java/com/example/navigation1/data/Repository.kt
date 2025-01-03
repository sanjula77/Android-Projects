package com.example.navigation1.data

interface Repository {
    fun getStudent(id: Int): Student?
    fun setStudent(student: Student)
}