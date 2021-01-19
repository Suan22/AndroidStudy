package com.example.diaryinmyhand

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.diaryinmyhand.databinding.ActivityDiaryWritingBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class DiaryWriting : AppCompatActivity() {
    private lateinit var binding: ActivityDiaryWritingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDiaryWritingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.Clock.setOnClickListener {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("a hh:mm").withLocale(Locale.forLanguageTag("us"))
            val formatted = current.format(formatter)

            binding.editText.text.insert(binding.editText.getSelectionStart(), formatted.toString())
        }
    }



}