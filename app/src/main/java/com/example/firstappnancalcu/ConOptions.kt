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

class ConOptions : AppCompatActivity() {

    private lateinit var iButton2: ImageButton
    private lateinit var buttonBasket: ImageButton
    private lateinit var buttonVase: ImageButton
    private lateinit var conDescription: TextView
    private lateinit var buttonNext2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_con_options)

        iButton2 = findViewById(R.id.instrucButton3)
        buttonBasket = findViewById(R.id.imageButtonBasket)
        buttonVase = findViewById(R.id.imageButtonVase)
        conDescription = findViewById(R.id.conDesc)
        buttonNext2 = findViewById(R.id.conNextButton)

        // instructions on the app flow
        iButton2.setOnClickListener{
            showPopup()
        }

        // to retrieve data from the last screen
        val flower = intent.getStringExtra("flower")

        // when image buttons are clicked, its description and the 'next' button will appear
        buttonBasket.setOnClickListener { navigateToLast(flower, "basket", "Brown Basket") }
        buttonVase.setOnClickListener { navigateToLast(flower, "vase", " Glass Vase") }
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

    // navigateToLast Function
    // has three parameters
    private fun navigateToLast(flower: String?, container: String, descriptionText: String) {
        conDescription.text = descriptionText
        buttonNext2.visibility = View.VISIBLE // makes button visible and updates textview

        //button will lead to next screen
        buttonNext2.setOnClickListener {
            val intent = Intent(this, LastActivity::class.java).apply {
                putExtra("flower", flower)
                putExtra("container", container) // to add extra data to the intent
            }
            startActivity(intent)
        }
    }

}