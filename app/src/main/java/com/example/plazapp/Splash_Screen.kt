package com.example.plazapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import java.util.logging.Logger

class Splash_Screen : AppCompatActivity() {
    private lateinit var handler:Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //handler = Handler(Looper.getMainLooper())
        //handler.postDelayed({startActivity(Intent(this,MainActivity::class.java))},3700)
    }
}