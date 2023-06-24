package com.example.demoday.remote

import com.example.demoday.remote.model.SignUpDto
import com.example.network.result.Resource
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("users/register/")
    suspend fun signUp(@Body signUpDto: SignUpDto): Resource<SignUpDto>

}