package com.example.firstappnancalcu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupWindow
import android.widget.TextView

class FlowerOptions : AppCompatActivity() {

    private lateinit var iButton: ImageButton
    private lateinit var buttonCam: ImageButton
    private lateinit var buttonTulip: ImageButton
    private lateinit var buttonFlower: ImageButton
    private lateinit var flowerDescription: TextView
    private lateinit var buttonNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flower_options)

        iButton = findViewById(R.id.instrucButton2)
        buttonCam = findViewById(R.id.imageButtonCam)
        buttonTulip = findViewById(R.id.imageButtonTulip)
        buttonFlower = findViewById(R.id.imageButtonDaisy)
        flowerDescription = findViewById(R.id.flowerDesc)
        buttonNext = findViewById(R.id.flowerNextButton)

        // instructions on the app flow
        iButton.setOnClickListener{
            showPopup()
        }

        // when image buttons are clicked, its description and the 'next' button will appear
        buttonCam.setOnClickListener { showNextButton("camellia", "Camellia") }
        buttonTulip.setOnClickListener { showNextButton("tulip", "Tulip") }
        buttonFlower.setOnClickListener{ showNextButton("daisy", "Gerbara Daisy")}
    }

    // FUNCTIONS
    // showPopup Function
    // provide instructions
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

    // showNextButton Function
    // has two parameters
    private fun showNextButton(flower: String, descriptionText: String) {
        flowerDescription.text = descriptionText
        buttonNext.visibility = View.VISIBLE // to make button visible and update the textview when choice has been clicked

        //button will lead to next screen
        buttonNext.setOnClickListener {
            // to initiate the next screen which is SecondActivity
            val intent = Intent(this, ConOptions::class.java).apply {
                putExtra("flower", flower) // to add extra data to the intent
            }
            startActivity(intent)
        }

    }
}