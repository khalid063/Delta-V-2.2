package com.example.deltav22.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.example.deltav22.R


/// ---------- Custom PopUp ----------///

fun showCustomPopup(
    context: Context,
    message: String,
    onYesClicked: () -> Unit,
    onNoClicked: () -> Unit
) {
    // Create a dialog object
    val dialog = Dialog(context)

    // Set the dialog feature to remove the title bar
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog.setCancelable(false)  // Make sure the dialog is not dismissible by tapping outside

    // Set the content view to your custom layout for the popup
    dialog.setContentView(R.layout.custom_popup)

    // Safely find the TextView to set the message
    val tvMessage = dialog.findViewById<TextView>(R.id.tv_message)
    if (tvMessage != null) {
        tvMessage.text = message // Set the message dynamically
    } else {
        Log.e("showCustomPopup", "TextView with ID tv_message not found in layout")
    }

    // Safely find the Yes button and set its onClickListener
    val btnYes = dialog.findViewById<Button>(R.id.btn_yes)
    if (btnYes != null) {
        btnYes.setOnClickListener {
            onYesClicked()  // Execute the "Yes" action
            dialog.dismiss()  // Close the dialog
        }
    } else {
        Log.e("showCustomPopup", "Button with ID btn_yes not found in layout")
    }

    // Safely find the No button and set its onClickListener
    val btnNo = dialog.findViewById<Button>(R.id.btn_no)
    if (btnNo != null) {
        btnNo.setOnClickListener {
            onNoClicked()  // Execute the "No" action
            dialog.dismiss()  // Close the dialog
        }
    } else {
        Log.e("showCustomPopup", "Button with ID btn_no not found in layout")
    }

    // Show the dialog safely on the main UI thread
    if (context is Activity && !context.isFinishing) {
        dialog.show()
    } else {
        Log.e("showCustomPopup", "Context is not an active Activity, dialog won't be shown.")
    }
}


//fun showCustomPopup(
//    context: Context,
//    message: String,
//    onYesClicked: () -> Unit,
//    onNoClicked: () -> Unit
//) {
//    val dialog = Dialog(context)
//    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//    dialog.setCancelable(false)
//    dialog.setContentView(R.layout.custom_popup)
//
//    val tvMessage = dialog.findViewById<TextView>(R.id.tv_message)
//    tvMessage.text = message
//
//    val btnYes = dialog.findViewById<Button>(R.id.btn_yes)
//    btnYes.setOnClickListener {
//        onYesClicked() // Execute the "Yes" action
//        dialog.dismiss()
//    }
//
//    val btnNo = dialog.findViewById<Button>(R.id.btn_no)
//    btnNo.setOnClickListener {
//        onNoClicked() // Execute the "No" action
//        dialog.dismiss()
//    }
//
//    dialog.show()
//}



