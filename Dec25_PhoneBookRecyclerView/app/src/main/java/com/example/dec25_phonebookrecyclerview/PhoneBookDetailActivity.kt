package com.example.dec25_phonebookrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dec25_phonebookrecyclerview.databinding.ActivityPhoneBookDetailBinding

class PhoneBookDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPhoneBookDetailBinding.inflate(layoutInflater)//두번 선언해줘야한다.
        setContentView(binding.root)
        getPersonInfoAndDraw()

        binding.back.setOnClickListener {
            onBackPressed()
        }


    }

    fun getPersonInfoAndDraw(){
        val binding = ActivityPhoneBookDetailBinding.inflate(layoutInflater) //두번 선언해줘야한다.
        val name=intent.getStringExtra("name")
        val number=intent.getStringExtra("number")
        binding.personDetailName.text=name
        binding.personDetailNumber.text=number

    }
}