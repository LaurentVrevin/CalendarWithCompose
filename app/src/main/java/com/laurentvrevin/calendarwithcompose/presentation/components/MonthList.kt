package com.laurentvrevin.calendarwithcompose.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

@SuppressLint("NewApi")
@Composable
fun MonthList(
    selectedMonth: Int,
    onMonthSelected: (Int) -> Unit,
    selectedYear: Int,
    listState: LazyListState,
    modifier: Modifier
) {

        LazyColumn(
            state = listState,
            modifier = Modifier
                .padding(8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            items((1..12).toList()) { month ->
                Text(
                    text = YearMonth.of(selectedYear, month)
                        .month.getDisplayName(TextStyle.FULL, Locale.ENGLISH),
                    modifier = Modifier
                        .wrapContentWidth()
                        .clickable { onMonthSelected(month) }
                        .padding(8.dp),
                    textAlign = TextAlign.Center,
                    style = if (month == selectedMonth) MaterialTheme.typography.bodyLarge.copy(
                        color = MaterialTheme.colorScheme.primary
                    ) else MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
