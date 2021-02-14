package com.example.dec24_resource

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.dec24_resource.databinding.ActivityResourceBinding

//리소스를 불러오는 방법(R.___.id)

class Resource : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        val ment = resources.getString(R.string.hello)
        Log.d("mentt","ment : "+ment)
//이렇게
        val ment2 = getString(R.string.hello)
        Log.d("mentt","ment : "+ment2)

        val color = getColor(R.color.text_view)
        Log.d("mentt","color : "+color)


    }
}