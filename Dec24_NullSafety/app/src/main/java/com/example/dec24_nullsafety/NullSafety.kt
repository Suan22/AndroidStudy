package com.example.a16nov_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.dec24_nullsafety.R

class NullSafety : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safety)

        val number:Int = 10


        val number1:Int? = null

        val number3 = number1?.plus(number)

        Log.d("number","number3 : " +number3)
        //삼항 연산자 -> 엘비스 연산자(?:)
        //null safety를 위해 제공
        val number4 = number1?:10
        Log.d("number","number4 : " +number4)


    }

    fun plus(a:Int,b:Int?):Int{
        if(b != null) return a + b
        else return a
    }
    // 위, 아래 두개는 같은 코드
    fun plus2(a:Int,b:Int?):Int?
    {
        return b?.plus(a)
    }
}