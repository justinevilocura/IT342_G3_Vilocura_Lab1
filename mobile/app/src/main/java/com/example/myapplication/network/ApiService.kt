package com.example.myapplication.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("api/auth/login")
    fun login(@Body request: LoginRequest): Call<JwtResponse>

    @POST("api/auth/register")
    fun register(@Body request: SignupRequest): Call<MessageResponse>

    @POST("api/auth/logout")
    fun logout(): Call<MessageResponse>

    @GET("api/user/me")
    fun getCurrentUser(@Header("Authorization") token: String): Call<UserProfile>
}
