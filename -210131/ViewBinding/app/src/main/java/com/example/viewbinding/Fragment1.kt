package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.example.viewbinding.databinding.ActivityFragment1Binding

class Fragment1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFragment1Binding.inflate(layoutInflater) // 인플레이트는 '프라그먼트1을 그릴거야' 라는 뜻
        setContentView(binding.root)
        val fragmentOne:FragmentOne=FragmentOne()

        binding.frag1.setOnClickListener {
            val fragmentManager: FragmentManager = supportFragmentManager
//Transaction: 작업의 단위(시작과 끝이 있다.)
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,fragmentOne)
            fragmentTransaction.commit()

//끝을 내는 방법
//commit(): 시간날때 끝내줘(좀더 안정적이다.) commitnow(): 바로 끝내줘
        }

        binding.frag2.setOnClickListener {
            val fragmentManager: FragmentManager = supportFragmentManager
//Transaction: 작업의 단위(시작과 끝이 있다.)
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,fragmentOne)
            fragmentTransaction.commit()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("Life-Cycle","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Life-Cycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Life-Cycle","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Life-Cycle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Life-Cycle","onDestroy")
    }

}