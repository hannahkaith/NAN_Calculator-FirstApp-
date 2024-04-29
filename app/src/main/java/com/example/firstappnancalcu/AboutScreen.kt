package com.example.firstappnancalcu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class AboutScreen : AppCompatActivity() {

    private lateinit var homeButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_screen)

        homeButton = findViewById(R.id.back2home)
        // Direct user back to the home screen
        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java) // an Intent to start the MainActivity aka home screen
            startActivity(intent)
            finish() // to finish current screen
        }
    }
}