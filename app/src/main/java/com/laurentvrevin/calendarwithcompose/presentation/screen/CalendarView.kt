package com.laurentvrevin.calendarwithcompose.presentation.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarView(modifier: Modifier = Modifier) {

    var displayedMonth by remember { mutableStateOf(YearMonth.now()) }

    // Calculate days and first day of the month
    val daysInMonth = displayedMonth.lengthOfMonth()
    val firstDayOfMonth = displayedMonth.atDay(1).dayOfWeek.value
    val daysOfWeek = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            text = "${
                displayedMonth.month.getDisplayName(
                    TextStyle.FULL,
                    Locale.getDefault()
                )
            } ${displayedMonth.year}",
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        // Navigate between months

        Spacer(modifier = Modifier.height(16.dp))

        // Days of the week
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            daysOfWeek.forEach { day ->
                Text(
                    text = day,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Calendar Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(7), //
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            // Spaces before the first day of the month
            items(firstDayOfMonth - 1) {
                Box(modifier = Modifier.height(40.dp))
            }

            // Days of the month
            items(daysInMonth) { day ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(40.dp)
                        .background(MaterialTheme.colorScheme.primaryContainer)

                ) {
                    Text(text = "${day + 1}") //Show day's number
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(onClick = { displayedMonth = displayedMonth.minusMonths(1) }) {
                Text("<")
            }
            Button(onClick = { displayedMonth = YearMonth.now() }) {
                Text("Today")
            }
            Button(onClick = { displayedMonth = displayedMonth.plusMonths(1) }) {
                Text(">")
            }
        }

    }
}