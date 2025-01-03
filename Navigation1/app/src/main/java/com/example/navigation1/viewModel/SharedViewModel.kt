package com.example.navigation1.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.navigation1.data.Student

class SharedViewModel: ViewModel() {
    val student = MutableLiveData<Student>()
}