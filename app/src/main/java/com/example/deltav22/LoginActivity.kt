package com.example.deltav22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //--- code for
        val loginButton = findViewById<Button>(R.id.id_login_button)
        loginButton.setOnClickListener {
            // Start HomeActivity
            val intent = Intent(this, HomeDashboardActivity::class.java)
            startActivity(intent)
        }


    }
    ///================================================== below OnCreate ============================================///




}