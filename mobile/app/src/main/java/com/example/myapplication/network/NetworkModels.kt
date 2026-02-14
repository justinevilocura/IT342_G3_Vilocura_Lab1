package com.example.myapplication.network

data class LoginRequest(
    val username: String,
    val password: String
)

data class SignupRequest(
    val username: String,
    val email: String,
    val password: String
)

data class JwtResponse(
    val token: String,
    val id: Long,
    val username: String,
    val email: String,
    val role: String
)

data class MessageResponse(
    val message: String
)

data class UserProfile(
    val id: Long,
    val username: String,
    val email: String,
    val role: String
)
