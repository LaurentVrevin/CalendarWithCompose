package com.laurentvrevin.calendarwithcompose.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

@Composable
fun YearList(
    selectedYear: Int,
    onYearSelected: (Int) -> Unit,
    years: List<Int>,
    listState: LazyListState,
    modifier: Modifier
) {

    LazyColumn(
        state = listState,
        modifier = Modifier
            .padding(8.dp),
        verticalArrangement = Arrangement.Center
    ) {
        items(years) { year ->
            Text(
                text = year.toString(),
                modifier = Modifier
                    .wrapContentWidth()
                    .clickable { onYearSelected(year) }
                    .padding(8.dp),
                textAlign = TextAlign.Center,
                style = if (year == selectedYear) MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.primary
                ) else MaterialTheme.typography.bodyLarge
            )
        }
    }
    }
