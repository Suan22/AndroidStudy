package com.example.jan08_secondapp

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jakewharton.threetenabp.AndroidThreeTen
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.ViewContainer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidThreeTen.init(this)
    }


    }


class DayViewContainer(view: View) : ViewContainer(view) {
    val textView = view.calendarDayText

        calendarView.dayBinder=object:DayBinder<DayViewContainer> {
        override fun create(view: View): DayViewContainer(view)


        override fun bind(container: DayViewContainer, day: CalendarDay) {
            container.textView.text=day.date.dayOfMonth.toString()


        }
    }
}

