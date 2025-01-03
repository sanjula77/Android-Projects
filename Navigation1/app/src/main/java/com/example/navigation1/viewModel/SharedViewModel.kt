package com.example.navigation1.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.navigation1.data.NavRepository
import com.example.navigation1.data.Student

class SharedViewModel (repository: NavRepository): ViewModel() {
    val student = MutableLiveData<Student>()

    // Store id
    val id = MutableLiveData<Int>()
    private val repository by lazy { repository }

    fun getStudent(): Student {
        return repository.getStudent(id = id.value ?: 0)
    }
    fun setStudent(student: Student) {
        repository.setStudent(student = student)
    }
}