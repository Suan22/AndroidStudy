package com.example.movie_introductionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SystemClock.sleep(300)
        val intent = Intent(this,SubActivity::class.java)
        startActivity(intent)
        finish()

    }
}