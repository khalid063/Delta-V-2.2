package com.example.deltav22

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        /// --- code for settings bar color change ( above the ToolBar) ---///
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.white) // Replace with your color
        }

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