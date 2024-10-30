package com.example.deltav22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        // Access the ImageView by its ID
        val logoImageView: ImageView = findViewById(R.id.logoImageView)

        // Optionally, you can set properties or update the image programmatically
        logoImageView.setImageResource(R.drawable.logo_delta) // Set image resource if needed


        // Simulate loading
        Handler().postDelayed({
            // Navigate to MainActivity after 3 seconds
            startActivity(Intent(this, HomeDashboardActivity::class.java))
            finish()
        }, 3000) // 3 seconds delay




    }
}