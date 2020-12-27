package com.example.movie_introductionapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)


        Toast_btn.setOnClickListener {
            Toast.makeText(this@SubActivity, "토스트메시지 출력", Toast.LENGTH_SHORT).show()
        }
    }
}