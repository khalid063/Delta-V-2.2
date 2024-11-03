package com.example.deltav22

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import me.ibrahimsn.lib.SmoothBottomBar

class HomeDashboardActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_dashboard)

        /// --- code for settings bar color change ( above the ToolBar) ---///
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.pColorShadForStatusBar) // Replace with your color
        }

        //--- Load the default fragment when the app starts --///
        showFragment(HomeFragment())


        ///--- toolbar "LogOut Button" ---///
        findViewById<LinearLayout>(R.id.id_toolbarLogoutArea).setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Optional: finish the current activity if you don't want to return to it
        }


        ///============================================================== Drawar setup code ========================================================///
        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.navigation_view)

        // Set up the ImageView icon to open the drawer
        findViewById<ImageView>(R.id.home_id).setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        // Handle navigation item clicks
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Handle "Home" action
                    //mainLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.AppBorderColor))
                    true
                }
                R.id.nav_settings -> {
                    // Handle "Settings" action
                    true
                }
                R.id.nav_logout2 -> {
                    // Handle "Logout" action
                    true
                }
                R.id.nav_logout3 -> {
                    // Handle "Logout" action
                    true
                }
                R.id.nav_logout4 -> {
                    // Handle "Logout" action
                    true
                }
                R.id.nav_logout5 -> {
                    // Handle "Logout" action
                    true
                }
                else -> false
            }
        }

        ///--- Bottom navbar fragment change code ---///
        val bottomBar: SmoothBottomBar = findViewById(R.id.bottomBar)
//        bottomBar.inflateMenu(R.menu.bottom_menu)

        // Set up bottom bar menu items
        bottomBar.onItemSelected = { position ->
            when (position) {
                0 -> showFragment(HomeFragment())
                1 -> showFragment(AchievementFragment())
                2 -> showFragment(ReportsFragment())
            }
            true
        }






    }
    ///============================================================== Below of OnCreate ====================================================================///

    //--- Fragment change Function ---///
    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }








}





















//package com.example.deltav22
//
//import android.os.Build
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.ImageView
//import androidx.appcompat.widget.Toolbar
//import androidx.core.content.ContextCompat
//
//class HomeDashboardActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home_dashboard)
//
//
//
//
//
//
//
//
//
//        // Set the status bar color
//        //window.statusBarColor = ContextCompat.getColor(this, R.color.GreenMainDark) // Replace with your color
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            window.statusBarColor = ContextCompat.getColor(this, R.color.pColorShadForStatusBar) // Replace with your color
//        }
//
//
////        val toolbar: Toolbar = findViewById(R.id.toolbar)
////        setSupportActionBar(toolbar)
////
////        // Add drawer icon
////        toolbar.setNavigationIcon(R.drawable.ic_menu)
////        toolbar.setNavigationOnClickListener {
////            // Handle drawer opening logic here
////        }
////
////        // Set page title
////        toolbar.title = "Delta"
////
////        // Add bell icon
////        val bellIcon = ImageView(this)
////        bellIcon.setImageResource(R.drawable.ic_menu)
////        toolbar.addView(bellIcon)
////
////        // Add logout icon
////        val logoutIcon = ImageView(this)
////        logoutIcon.setImageResource(R.drawable.ic_menu)
////        toolbar.addView(logoutIcon)
//
//
//
//    }
//}