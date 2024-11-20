package com.example.deltav22.utils

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.deltav22.R


/// ---------- Custom PopUp ----------///
fun showCustomPopup(
    context: Context,
    message: String,
    onYesClicked: () -> Unit,
    onNoClicked: () -> Unit
) {
    val dialog = Dialog(context)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setCancelable(false)
    dialog.setContentView(R.layout.custom_popup)

    val tvMessage = dialog.findViewById<TextView>(R.id.tv_message)
    tvMessage.text = message

    val btnYes = dialog.findViewById<Button>(R.id.btn_yes)
    btnYes.setOnClickListener {
        onYesClicked() // Execute the "Yes" action
        dialog.dismiss()
    }

    val btnNo = dialog.findViewById<Button>(R.id.btn_no)
    btnNo.setOnClickListener {
        onNoClicked() // Execute the "No" action
        dialog.dismiss()
    }

    dialog.show()
}

// ---------- custom Toast successful ! code ---------- ///
//fun showCustomToast(message: String) {
//    // Inflate custom Toast layout
//    val layoutInflater = layoutInflater
//    val layout = layoutInflater.inflate(R.layout.custom_toast_green, null)
//
//    // Set the message in the custom Toast
//    val toastMessage = layout.findViewById<TextView>(R.id.toast_message)
//    toastMessage.text = message
//
//    // Create and display the Toast
//    val toast = Toast(applicationContext)
//    toast.duration = Toast.LENGTH_SHORT
//    toast.view = layout
//    toast.show()
//}


