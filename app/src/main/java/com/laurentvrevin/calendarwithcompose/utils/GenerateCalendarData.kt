package com.laurentvrevin.calendarwithcompose.utils

import android.annotation.SuppressLint
import com.laurentvrevin.calendarwithcompose.domain.model.CalendarData
import java.time.YearMonth

@SuppressLint("NewApi")
fun generateCalendarData(displayedMonth: YearMonth): CalendarData {
    val daysInMonth = displayedMonth.lengthOfMonth()
    val firstDayOfMonth = displayedMonth.atDay(1).dayOfWeek.value
    val previousMonth = displayedMonth.minusMonths(1)
    val daysInPreviousMonth = previousMonth.lengthOfMonth()
    val daysBefore = (1..<firstDayOfMonth).map { daysInPreviousMonth - (firstDayOfMonth - 1) + it }
    val totalGridItems = 7 * ((daysBefore.size + daysInMonth) / 7 + 1)
    val daysAfter = (1..(totalGridItems - daysBefore.size - daysInMonth)).toList()

    return CalendarData(
        daysBefore = daysBefore,
        daysInMonth = (1..daysInMonth).toList(),
        daysAfter = daysAfter
    )
}