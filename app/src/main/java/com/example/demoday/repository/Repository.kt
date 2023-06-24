package com.example.demoday.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.demoday.remote.ApiService
import com.example.demoday.remote.model.SignUpDto
import com.example.network.result.Resource
import kotlinx.coroutines.Dispatchers

class Repository(private val apiService: ApiService) {

    fun signUp(signUpDto: SignUpDto): LiveData<Resource<SignUpDto>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val response = apiService.signUp(signUpDto)
            emit(response)
        }
    }
}