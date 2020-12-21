package com.example.nov22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.sublayout.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sublayout)
        Log.d("Life-Cycle","onCreate")

        hello.setOnClickListener {
            Log.d("Hello!","뜌앙")
            hello.text="GoodBye"
        }

        btn1.setOnClickListener {
            Toast.makeText(this, "버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show()
        }

    }


}
