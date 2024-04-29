package com.example.firstappnancalcu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class LastActivity : AppCompatActivity() {

    private lateinit var homeButton: ImageButton
    private lateinit var finalProduct: ImageView
    private lateinit var lastDescription: TextView
    private lateinit var restartProcess: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last)

        homeButton = findViewById(R.id.back2home2)
        finalProduct = findViewById(R.id.finalProduct)
        lastDescription = findViewById(R.id.lastDesc)
        restartProcess = findViewById(R.id.buttonRestart)

        // to retrieve the data from the last two screens
        val flower = intent.getStringExtra("flower")
        val container = intent.getStringExtra("container")

        // to present the final product image depending on the options
        val finalProductImage = when ("${flower}_${container}") {
            "camellia_basket" -> R.drawable.camellia_brownbasket
            "camellia_vase" -> R.drawable.camellia_glassvase
            "tulip_basket" -> R.drawable.tulip_brownbasket
            "tulip_vase" -> R.drawable.tulip_glassvase
            "daisy_basket" -> R.drawable.daisy_brownbasket
            "daisy_vase" -> R.drawable.daisy_glassvase
            else -> R.drawable.bloomintime_logosmaller // this is a default image
        }

        // to present the fact and other info depending on the options
        val fact = when ("${flower}_${container}") { // facts and info
            "camellia_basket" -> "Wonderful Choice!\nIt is believed that deep red\ncamellias convey passion, love,\nromance, and desire."
            "camellia_vase" -> "Excellent!\nA species of camellia,\nCamellia sinensis, produces\nblack, white, and green tea."
            "tulip_basket" -> "Beautiful~\nTulips are an ideal way\nto express unconditional love\nto someone."
            "tulip_vase" -> "Adding vibrant yellow tulips\nto your living space will give\nit a joyful, contented feel!"
            "daisy_basket" -> "Great Decision!\nGerberas generally represent\npurity, innocence, joy,\nand loyal affection.\n"
            "daisy_vase" -> "Lovely <3\nThe gerbera flower is\nessentially a collection of\nmany small individual flowers.\n"
            else -> "Have a beautiful day, love <3" // default text
        }

        finalProduct.setImageResource(finalProductImage)
        lastDescription.text = fact

        // directs user back to home screen
        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java) // an Intent to start MainActivity aka home screen
            startActivity(intent)
            finish() // to accomplish current screen
        }

        // Restart the process
        restartProcess.setOnClickListener {
            startActivity(Intent(this, FlowerOptions::class.java))
        }
    }
}