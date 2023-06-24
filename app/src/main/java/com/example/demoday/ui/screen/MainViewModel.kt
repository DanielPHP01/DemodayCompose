package com.example.demoday.ui.screen

import androidx.lifecycle.LiveData
import com.example.demoday.remote.model.SignUpDto
import com.example.demoday.repository.Repository
import com.example.network.result.Resource
import com.example.network.ui.BaseViewModel

class MainViewModel(private val repository: Repository) : BaseViewModel() {

    fun signUp(signUpDto: SignUpDto): LiveData<Resource<SignUpDto>> {
        return repository.signUp(signUpDto)
    }
}