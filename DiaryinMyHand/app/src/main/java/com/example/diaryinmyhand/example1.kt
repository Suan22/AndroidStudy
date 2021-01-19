package com.example.diaryinmyhand

import android.R
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.diaryinmyhand.databinding.ActivityExample1Binding


class example1 : AppCompatActivity() {
    private var textView_Date: TextView? = null
    private var callbackMethod: OnTimeSetListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityExample1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        InitializeView()
        InitializeListener()
        textView_Date = (binding.textView2) as TextView
    }

    fun InitializeView() {
        textView_Date
    }

    fun InitializeListener() {
        callbackMethod = OnTimeSetListener { view, hourOfDay, minute ->
            textView_Date!!.text = hourOfDay.toString() + "시" + minute + "분"
        }
    }

    fun OnClickHandler(view: View?) {
        val dialog = TimePickerDialog(this, callbackMethod, 8, 10, true)
        dialog.show()
    }
}


