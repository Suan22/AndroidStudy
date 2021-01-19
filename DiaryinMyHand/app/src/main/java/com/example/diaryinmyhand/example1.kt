package com.example.diaryinmyhand

import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.diaryinmyhand.databinding.ActivityExample1Binding
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

// 시계 누르면 시간 찍기 ! !

class example1 : AppCompatActivity() {
    private lateinit var binding: ActivityExample1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityExample1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("a hh시 mm분").withLocale(Locale.forLanguageTag("us"))
            val formatted = current.format(formatter)

            binding.editText.text.insert(binding.editText.getSelectionStart(), formatted.toString())
        }

    }
    /*
   private fun main(args: Array<String>) {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초")
        val formatted = current.format(formatter)

        println("Current: $formatted")


    }
     */

}





