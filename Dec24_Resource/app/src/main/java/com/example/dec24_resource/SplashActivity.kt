package com.example.dec24_resource

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import androidx.core.content.ContextCompat.startActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SystemClock.sleep(300)
        val intent = Intent(this,Resource::class.java)
        startActivity(intent)
        finish()

    }
}


