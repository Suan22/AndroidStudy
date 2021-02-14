package com.example.diaryinmyhand

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CalendarView
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diaryinmyhand.databinding.ActivityMainBinding
import java.io.FileInputStream
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var fname: String = ""
    var str: String = ""
    private var Datadb: DataDB? = null
    private var dataList = listOf<Data>()
    lateinit var mAdapter: DiaryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Datadb = DataDB.getInstance(this)
        mAdapter = DiaryAdapter(this, dataList)

        binding.calendarView3.setOnDateChangeListener { view, year, month, dayOfMonth ->
            binding.recyclerView.visibility=View.VISIBLE
            binding.diaryTextView.visibility=View.VISIBLE
            binding.diaryTextView.text = String.format("%d / %d / %d", year, month + 1, dayOfMonth)
            checkedDay(year, month, dayOfMonth) // checkedDay 메소드 호출
        }


        val r = Runnable {
            try {
                dataList = Datadb?.dataDao()?.getAll()!!
                mAdapter = DiaryAdapter(this, dataList)
                mAdapter.notifyDataSetChanged()

                binding.recyclerView.adapter = mAdapter
                binding.recyclerView.layoutManager = LinearLayoutManager(this)
                binding.recyclerView.setHasFixedSize(true)
            } catch (e: Exception) {
                Log.d("tag", "Error - $e")
            }
        }

        val thread = Thread(r)
        thread.start()

        binding.Settings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        binding.Calendar.setOnClickListener {
            val intent1 = Intent(this, CalendarActivity::class.java)
            startActivity(intent1)
        }

        binding.Plus.setOnClickListener {
            val i = Intent(this, DiaryWriting::class.java)
            startActivity(i)
            finish()
        }

    }

    override fun onDestroy() {
        DataDB.destroyInstance()
        Datadb = null
        super.onDestroy()
    }

    fun checkedDay(cYear: Int, cMonth: Int, cDay: Int) {
        fname = "" + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt"
// 저장할 파일 이름 설정. Ex) 2019-01-20.txt
        var fis: FileInputStream? = null // FileStream fis 변수 설정

        try {
            fis = openFileInput(fname) // fname 파일 오픈!!

            val fileData = ByteArray(fis.available()) // fileData에 파이트 형식
//으로 저장
            fis.read(fileData) // fileData를 읽음
            fis.close()

            str = String(fileData) // str 변수에 fileData를 저장

            binding.recyclerView.visibility=View.VISIBLE
            binding.diaryTextView.visibility=View.VISIBLE



        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}

