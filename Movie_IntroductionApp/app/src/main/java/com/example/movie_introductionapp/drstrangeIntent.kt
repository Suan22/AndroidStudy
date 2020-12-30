package com.example.movie_introductionapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.movie_introductionapp.databinding.ActivityDrstrangeIntentBinding
import kotlinx.android.synthetic.main.activity_drstrange_intent.*

class drstrangeIntent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityDrstrangeIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        savebutton.setOnClickListener {
            Toast.makeText(this@drstrangeIntent,"저장은 모태요^_ㅜ", Toast.LENGTH_LONG).show()
        }

        playbutton.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=2ojyCukJOjw"))
            startActivity(intent)
        }
        binding.imageButton1.setOnClickListener {
            val intent = Intent(this@drstrangeIntent,civilwarIntent::class.java)
            intent.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivityForResult(intent, 200)
        }
        binding.imageButton2.setOnClickListener {
            val intent = Intent(this@drstrangeIntent,captainIntent::class.java)
            intent.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivityForResult(intent, 200)
        }
        binding.imageButton3.setOnClickListener {
            val intent = Intent(this@drstrangeIntent,ironmanIntent::class.java)
            intent.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivityForResult(intent, 200)
        }
        binding.imageButton7.setOnClickListener {
            val intent = Intent(this@drstrangeIntent,endgameIntent::class.java)
            intent.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivityForResult(intent, 200)
        }
        binding.imageButton8.setOnClickListener {
            val intent = Intent(this@drstrangeIntent,infinitywarIntent::class.java)
            intent.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivityForResult(intent, 200)
        }
        binding.imageButton9.setOnClickListener {
            val intent = Intent(this@drstrangeIntent,thorIntent::class.java)
            intent.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivityForResult(intent, 200)
        }



    }
}
