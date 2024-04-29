package com.example.firstappnancalcu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupWindow

class MainActivity : AppCompatActivity() {

    private lateinit var aboutbloomintime : ImageButton // about app
    private lateinit var startButton: Button //start process
    private lateinit var showPopupInfo : Button // popup instructions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        aboutbloomintime = findViewById(R.id.logoButton)
        startButton = findViewById(R.id.startButton)
        showPopupInfo = findViewById(R.id.instrucButton)

        // information about the app
        aboutbloomintime.setOnClickListener {
            val intent = Intent(this, AboutScreen::class.java)
            startActivity(intent)
            finish()
        }

        // starting the process
        startButton.setOnClickListener{
            val intent = Intent(this, FlowerOptions::class.java)
            startActivity(intent)
            finish()
        }

        // instructions on the app flow
        showPopupInfo.setOnClickListener{
            showPopup()
        }
    }

    // showPopup Function
    private fun showPopup(){
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.popup,null)

        //size of the popup
        val width = 950
        val height = 1650

        val instructWindow = PopupWindow(popupView, width, height,true)
        instructWindow.showAtLocation(popupView, Gravity.BOTTOM, 8, 385) //where it'll be positioned

        // Close popup
        val closeButton = popupView.findViewById<Button>(R.id.closeButton)
        closeButton.setOnClickListener{
            instructWindow.dismiss()
        }
    }
}