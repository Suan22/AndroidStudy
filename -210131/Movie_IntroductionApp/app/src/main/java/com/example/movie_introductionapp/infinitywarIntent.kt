package com.example.movie_introductionapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.movie_introductionapp.databinding.ActivityInfinitywarIntentBinding
import kotlinx.android.synthetic.main.activity_infinitywar_intent.*

class infinitywarIntent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityInfinitywarIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        savebutton.setOnClickListener {
            Toast.makeText(this@infinitywarIntent,"저장은 모태요^_ㅜ", Toast.LENGTH_LONG).show()
        }

        playbutton.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=ksZR8xjGuBA"))
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
        binding.imageButton4.setOnClickListener {
            val intent = Intent(this,spidermanIntent::class.java)
            intent.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivityForResult(intent, 200)
        }
        binding.imageButton5.setOnClickListener {
            val intent = Intent(this,guardiansIntent::class.java)
            intent.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivityForResult(intent, 200)
        }
        binding.imageButton6.setOnClickListener {
            val intent = Intent(this,drstrangeIntent::class.java)
            intent.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivityForResult(intent, 200)
        }
    }
}
