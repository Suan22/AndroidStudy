package com.example.movie_introductionapp

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sub.*
import com.example.movie_introductionapp.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageButton3.setOnClickListener {
            val intent = Intent(this@SubActivity,ironmanIntent::class.java)
            intent.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }

            startActivityForResult(intent, 200)
        }
    }
}


