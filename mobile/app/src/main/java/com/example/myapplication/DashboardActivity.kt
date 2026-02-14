package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.network.ApiClient
import com.example.myapplication.network.MessageResponse
import com.example.myapplication.network.UserProfile
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val tvProfileInfo = findViewById<TextView>(R.id.tvProfileInfo)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        val token = intent.getStringExtra("JWT_TOKEN") ?: ""

        if (token.isEmpty()) {
            Toast.makeText(this, "Session expired, please login again", Toast.LENGTH_SHORT).show()
            redirectToLogin()
            return
        }

        // Fetch User Profile
        ApiClient.apiService.getCurrentUser("Bearer $token").enqueue(object : Callback<UserProfile> {
            override fun onResponse(call: Call<UserProfile>, response: Response<UserProfile>) {
                if (response.isSuccessful) {
                    val user = response.body()
                    user?.let {
                        tvWelcome.text = "Welcome, ${it.username}!"
                        tvProfileInfo.text = "Email: ${it.email}\nRole: ${it.role}"
                    }
                } else {
                    Toast.makeText(this@DashboardActivity, "Failed to load profile", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserProfile>, t: Throwable) {
                Toast.makeText(this@DashboardActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

        btnLogout.setOnClickListener {
            ApiClient.apiService.logout().enqueue(object : Callback<MessageResponse> {
                override fun onResponse(call: Call<MessageResponse>, response: Response<MessageResponse>) {
                    Toast.makeText(this@DashboardActivity, "Logged out successfully", Toast.LENGTH_SHORT).show()
                    redirectToLogin()
                }

                override fun onFailure(call: Call<MessageResponse>, t: Throwable) {
                    // Even if network fails, logout on client side
                    Toast.makeText(this@DashboardActivity, "Logged out", Toast.LENGTH_SHORT).show()
                    redirectToLogin()
                }
            })
        }
    }

    private fun redirectToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}
