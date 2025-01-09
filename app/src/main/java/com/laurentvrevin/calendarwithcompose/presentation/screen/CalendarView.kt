package com.laurentvrevin.calendarwithcompose.presentation.screen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.laurentvrevin.calendarwithcompose.presentation.components.CalendarGrid
import com.laurentvrevin.calendarwithcompose.presentation.components.CalendarHeader
import com.laurentvrevin.calendarwithcompose.presentation.components.DaysOfWeek
import com.laurentvrevin.calendarwithcompose.presentation.components.MonthYearPickerDialog
import com.laurentvrevin.calendarwithcompose.utils.generateCalendarData
import java.time.LocalDate
import java.time.YearMonth


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarView(modifier: Modifier = Modifier) {
    var displayedMonth by remember { mutableStateOf(YearMonth.now()) }
    val today = LocalDate.now()
    val calendarData = generateCalendarData(displayedMonth)
    var showPickerDialog by remember { mutableStateOf(false) }

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
            onTitleClick = { showPickerDialog = true }
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
        Button(
            onClick = { displayedMonth = YearMonth.now() },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Refresh, // Icône de mise à jour
                    contentDescription = "Refresh",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Today")


            }
        }
        if (showPickerDialog) {
            MonthYearPickerDialog(
                currentYearMonth = displayedMonth,
                onDismiss = { showPickerDialog = false },
                onYearMonthSelected = { newYearMonth ->
                    displayedMonth = newYearMonth
                }
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