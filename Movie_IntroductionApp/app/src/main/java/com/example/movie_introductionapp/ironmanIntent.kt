package com.example.movie_introductionapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.movie_introductionapp.databinding.ActivityIronmanIntentBinding

class ironmanIntent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityIronmanIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}


