package com.laurentvrevin.calendarwithcompose.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.laurentvrevin.calendarwithcompose.domain.model.CalendarData
import java.time.LocalDate
import java.time.YearMonth

@SuppressLint("NewApi")
@Composable
fun CalendarGrid(
    calendarData: CalendarData,
    today: LocalDate,
    displayedMonth: YearMonth
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(7),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(calendarData.daysBefore) { day ->
            DayItem(text = "$day", isGray = true)
        }
        items(calendarData.daysInMonth) { day ->
            val isToday = displayedMonth.atDay(day) == today
            DayItem(text = "$day", isToday = isToday)
        }
        items(calendarData.daysAfter) { day ->
            DayItem(text = "$day", isGray = true)
        }
    }
}