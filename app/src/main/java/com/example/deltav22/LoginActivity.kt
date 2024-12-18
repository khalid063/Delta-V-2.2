package com.example.deltav22

import LoginRequest
import LoginResponse
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    // Declare sharedPrefManager at the class level
    private lateinit var sharedPrefManager: SharedPrefManager


    /// ========================================================== OnCreate Section ========================================================= ///
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // ---------- Initialize sharedPrefManager ---------- ///
        sharedPrefManager = SharedPrefManager(this)

        // ---------- Username and password input fields
        val usernameInput = findViewById<EditText>(R.id.username_input)
        val passwordInput = findViewById<EditText>(R.id.password_input)
        val loginButton = findViewById<Button>(R.id.login_button)

        // ---------- Login Button Listener ---------- ///
        loginButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                login(username, password)
            } else {
                Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
            }
        }

        // Change the status bar color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        }

    }

    /// ========================================================== below the "OnCreate" ====================================================== ///

    // ---------- Login function ----------///
    private fun login(username: String, password: String) {
        val request = LoginRequest(username, password)
        val call: Call<LoginResponse> = RetrofitClient.instance.login(request)

        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val token = response.body()!!.token
                    sharedPrefManager.saveAuthToken(token)
                    //Toast.makeText(this@LoginActivity, "Login successful!", Toast.LENGTH_SHORT).show()
                    showCustomToast("Login successful!")

                    // Navigate to the HomeDashboardActivity
                    val intent = Intent(this@LoginActivity, HomeDashboardActivity::class.java)
                    startActivity(intent)
                    finish() // Close the LoginActivity
                } else {
                    Toast.makeText(this@LoginActivity, "Login failed. Please check your credentials.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

                // Print error message in Logcat
                Log.e("LoginActivity", "Login API call failed", t)

                Toast.makeText(this@LoginActivity, "An error occurred: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    // ---------- custom Toast successful ! code ---------- ///
    private fun showCustomToast(message: String) {
        // Inflate custom Toast layout
        val layoutInflater = layoutInflater
        val layout = layoutInflater.inflate(R.layout.custom_toast_green, null)

        // Set the message in the custom Toast
        val toastMessage = layout.findViewById<TextView>(R.id.toast_message)
        toastMessage.text = message

        // Create and display the Toast
        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.show()
    }

}
