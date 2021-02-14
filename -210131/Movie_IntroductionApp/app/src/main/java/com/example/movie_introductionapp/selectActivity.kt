package com.example.movie_introductionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.movie_introductionapp.databinding.ActivitySelectBinding
import com.example.movie_introductionapp.databinding.ActivitySpidermanIntentBinding
import kotlinx.android.synthetic.main.activity_select.*

class selectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivitySelectBinding.inflate(layoutInflater)
        setContentView(binding.root)


        imageButton11.setOnClickListener {
            Toast.makeText(this@selectActivity, "꽝", Toast.LENGTH_SHORT).show()
        }
        imageButton22.setOnClickListener {
            Toast.makeText(this@selectActivity, "놉!", Toast.LENGTH_SHORT).show()
        }
        imageButton33.setOnClickListener {
            Toast.makeText(this@selectActivity, "꽝꽝꽝", Toast.LENGTH_SHORT).show()
        }
        imageButton44.setOnClickListener {
            Toast.makeText(this@selectActivity, "정답^_____^", Toast.LENGTH_SHORT).show()
        }
        imageButton55.setOnClickListener {
            Toast.makeText(this@selectActivity, "ㅋ_ㅋ", Toast.LENGTH_SHORT).show()
        }

        binding.imageButton44.setOnClickListener {
            val intent = Intent(this@selectActivity, SubActivity::class.java)
            intent.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivityForResult(intent, 200)
        }

    }
}