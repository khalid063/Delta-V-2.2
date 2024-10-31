package com.example.deltav22

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

class HomeDashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_dashboard)

        // Set the status bar color
        //window.statusBarColor = ContextCompat.getColor(this, R.color.GreenMainDark) // Replace with your color

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.pColorShadForStatusBar) // Replace with your color
        }


//        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)
//
//        // Add drawer icon
//        toolbar.setNavigationIcon(R.drawable.ic_menu)
//        toolbar.setNavigationOnClickListener {
//            // Handle drawer opening logic here
//        }
//
//        // Set page title
//        toolbar.title = "Delta"
//
//        // Add bell icon
//        val bellIcon = ImageView(this)
//        bellIcon.setImageResource(R.drawable.ic_menu)
//        toolbar.addView(bellIcon)
//
//        // Add logout icon
//        val logoutIcon = ImageView(this)
//        logoutIcon.setImageResource(R.drawable.ic_menu)
//        toolbar.addView(logoutIcon)



    }
}