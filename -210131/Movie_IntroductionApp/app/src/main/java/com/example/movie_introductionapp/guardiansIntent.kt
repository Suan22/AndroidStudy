package com.example.movie_introductionapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.movie_introductionapp.databinding.ActivityGuardiansIntentBinding
import kotlinx.android.synthetic.main.activity_guardians_intent.*

class guardiansIntent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityGuardiansIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        savebutton.setOnClickListener {
            Toast.makeText(this@guardiansIntent,"저장은 모태요^_ㅜ", Toast.LENGTH_LONG).show()
        }

        playbutton.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=1V-GC1pnv44"))
            startActivity(intent)
        }

        binding.imageButton1.setOnClickListener {
            val intent = Intent(this,civilwarIntent::class.java)
            intent.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivityForResult(intent, 200)
        }
        binding.imageButton2.setOnClickListener {
            val intent = Intent(this,captainIntent::class.java)
            intent.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivityForResult(intent, 200)
        }
        binding.imageButton3.setOnClickListener {
            val intent = Intent(this,ironmanIntent::class.java)
            intent.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivityForResult(intent, 200)
        }
        binding.imageButton7.setOnClickListener {
            val intent = Intent(this,endgameIntent::class.java)
            intent.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivityForResult(intent, 200)
        }
        binding.imageButton8.setOnClickListener {
            val intent = Intent(this,infinitywarIntent::class.java)
            intent.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivityForResult(intent, 200)
        }
        binding.imageButton9.setOnClickListener {
            val intent = Intent(this,thorIntent::class.java)
            intent.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivityForResult(intent, 200)
        }

    }
}
