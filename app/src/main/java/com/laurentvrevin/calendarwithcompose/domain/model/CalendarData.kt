package com.laurentvrevin.calendarwithcompose.domain.model

data class CalendarData(
    val daysBefore: List<Int>,
    val daysInMonth: List<Int>,
    val daysAfter: List<Int>
)