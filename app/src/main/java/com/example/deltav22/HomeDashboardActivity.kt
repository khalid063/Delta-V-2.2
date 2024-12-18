package com.example.deltav22

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.deltav22.utils.showCustomPopup
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


        ///--- toolbar "LogOut Button" with "Alart PopUp" ---///
        findViewById<LinearLayout>(R.id.id_toolbarLogoutArea).setOnClickListener {
            showCustomPopup(
                this,
                "Are you sure you want to logout?",
                onYesClicked = {
                    // "Yes" action
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                },
                onNoClicked = {
                    // "No" action
                    // For example, show a Toast message or perform some other action
                    //Toast.makeText(this, "Logout canceled", Toast.LENGTH_SHORT).show()
                    //showCustomToast("Logout canceled Done!")
                }
            )
        }



//        findViewById<LinearLayout>(R.id.id_toolbarLogoutArea).setOnClickListener {
//            // Create an AlertDialog
//            val builder = AlertDialog.Builder(this)
//            builder.setTitle("Logout Confirmation")
//            builder.setMessage("Are you sure you want to logout?")
//
//            // Set up the "Yes" button
//            builder.setPositiveButton("Yes") { dialog, _ ->
//                // Perform logout action
//                val intent = Intent(this, LoginActivity::class.java)
//                startActivity(intent)
//                finish() // Finish current activity
//                dialog.dismiss() // Close the dialog
//            }
//
//            // Set up the "No" button
//            builder.setNegativeButton("No") { dialog, _ ->
//                // Simply dismiss the dialog
//                dialog.dismiss()
//            }
//
//            // Show the AlertDialog
//            builder.create().show()
//        }


//        findViewById<LinearLayout>(R.id.id_toolbarLogoutArea).setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//            finish() // Optional: finish the current activity if you don't want to return to it
//        }


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

    fun showCustomToast(message: String) {
        // Inflate custom Toast layout
        val layoutInflater = layoutInflater
        val layout = layoutInflater.inflate(R.layout.custom_toast_green, null)

        // Set the message in the custom Toast
        val toastMessage = layout.findViewById<TextView>(R.id.toast_message)
        toastMessage.text = message  // Use the dynamic message here

        // Create and display the Toast
        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.show()
    }


//    private fun showCustomToast(message: String) {
//        // Inflate custom Toast layout
//        val layoutInflater = layoutInflater
//        val layout = layoutInflater.inflate(R.layout.custom_toast_green, null)
//
//        // Set the message in the custom Toast
//        val toastMessage = layout.findViewById<TextView>(R.id.toast_message)
//        toastMessage.text = message
//
//        // Create and display the Toast
//        val toast = Toast(applicationContext)
//        toast.duration = Toast.LENGTH_SHORT
//        toast.view = layout
//        toast.show()
//    }








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