package com.example.diary2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diary2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        

        binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->  }
        setOnRangeSelectedListener { widget, dates ->
            if (!viewModel.checkDatesAvailable(dates)) {
                showToast(getString(R.string.date_can_not_selected_msg))
                binding.cvCalendar.clearSelection()
                viewModel.initDateRange()
                return@setOnRangeSelectedListener
            }
            viewModel.setStartDateTimestamp(dates[0])
            if (dates.size == 0) {
                viewModel.setEndDateTimestamp(dates[dates.size])
            } else if (dates.size != 1) {
                viewModel.setEndDateTimestamp(dates[dates.size - 1])
            }
            viewModel.setDateRange()
        }
        binding.cvCalendar.setOnDateChangedListener { widget, date, selected ->
            val calList = ArrayList<CalendarDay>()
            calList.add(date)
            when {
                !selected -> {
                    viewModel.initDateRange()
                    viewModel.isDateSelected = false
                    viewModel.setAllSelected()
                }
                !viewModel.checkDatesAvailable(calList) -> {
                    showToast(getString(R.string.date_can_not_selected_msg))
                    binding.cvCalendar.clearSelection()
                    viewModel.initDateRange()
                }
                else -> {
                    viewModel.setStartDateTimestamp(date)
                    viewModel.setEndDateTimestamp(date)
                    viewModel.isDateSelected = selected
                    viewModel.setAllSelected()
                    viewModel.setSingleDateRange()
                }
            }
        }
    }
}