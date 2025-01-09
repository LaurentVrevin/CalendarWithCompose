package com.laurentvrevin.calendarwithcompose.presentation.screen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.laurentvrevin.calendarwithcompose.presentation.components.CalendarGrid
import com.laurentvrevin.calendarwithcompose.presentation.components.CalendarHeader
import com.laurentvrevin.calendarwithcompose.presentation.components.DaysOfWeek
import com.laurentvrevin.calendarwithcompose.utils.generateCalendarData
import java.time.LocalDate
import java.time.YearMonth


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarView(modifier: Modifier = Modifier) {
    var displayedMonth by remember { mutableStateOf(YearMonth.now()) }
    val today = LocalDate.now()
    val calendarData = generateCalendarData(displayedMonth)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7EDE2))
            .padding(16.dp)
    ) {
        CalendarHeader(
            displayedMonth = displayedMonth,
            onPreviousMonth = { displayedMonth = displayedMonth.minusMonths(1) },
            onNextMonth = { displayedMonth = displayedMonth.plusMonths(1) },
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        DaysOfWeek()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            CalendarGrid(
                calendarData = calendarData,
                today = today,
                displayedMonth = displayedMonth
            )
        }
    }
}
@SuppressLint("NewApi")
@Preview
@Composable
fun CalendarViewPreview() {
    CalendarView()
}