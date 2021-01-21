package com.example.diaryinmyhand

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diaryinmyhand.databinding.ActivityExample1Binding
import com.example.diaryinmyhand.databinding.ActivityExample2Binding

class example2 : AppCompatActivity() {
    private lateinit var binding: ActivityExample2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityExample2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.edtSave.setText(App.prefs.myEditText)

        binding.btnSave.setOnClickListener {
            App.prefs.myEditText=binding.edtSave.text.toString()
        }



    }
}