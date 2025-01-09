package com.laurentvrevin.calendarwithcompose.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MonthYearPicker(
    selectedYear: Int,
    selectedMonth: Int,
    onYearSelected: (Int) -> Unit,
    onMonthSelected: (Int) -> Unit
) {
    val years = (1900..2100).toList()
    val monthListState = rememberLazyListState()
    val yearListState = rememberLazyListState()

    LaunchedEffect(Unit) {
        monthListState.scrollToItem(selectedMonth - 1)
        yearListState.scrollToItem(years.indexOf(selectedYear))
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        MonthList(
            selectedMonth = selectedMonth,
            onMonthSelected = onMonthSelected,
            selectedYear = selectedYear,
            listState = monthListState,
            modifier = Modifier
                .weight(1f)
                .background(Color.Cyan)
        )

        YearList(
            selectedYear = selectedYear,
            onYearSelected = onYearSelected,
            years = years,
            listState = yearListState,
            modifier = Modifier
                .weight(1f)
                .background(Color.Cyan)
        )
    }
}

@Preview
@Composable
fun MonthYearPickerPreview() {
    MonthYearPicker(
        selectedYear = 2023,
        selectedMonth = 8,
        onYearSelected = {},
        onMonthSelected = {})
}