package com.example.firstappnancalcu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreen : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 2000 // splash screen will be visible for 2000 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        android.os.Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java)) // double colons is the way to access the class files
            finish()
        },SPLASH_TIME_OUT)
    }
}