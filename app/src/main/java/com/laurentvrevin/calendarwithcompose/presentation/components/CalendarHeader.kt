package com.laurentvrevin.calendarwithcompose.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.IconButtonDefaults.iconButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*

@SuppressLint("NewApi")
@Composable
fun CalendarHeader(
    displayedMonth: YearMonth,
    onPreviousMonth: () -> Unit,
    onNextMonth: () -> Unit,
    onTitleClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = onPreviousMonth,
            colors = iconButtonColors(
                contentColor = Color.Black,
                containerColor = Color.Transparent)
        ){
                Icon(modifier = Modifier.size(48.dp),
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Previous Month"
                )
            }

        Text(
            text = "${displayedMonth.month.getDisplayName(TextStyle.FULL, Locale.ENGLISH)} ${displayedMonth.year}",
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier
                .clickable(onClick = onTitleClick)
                .padding(8.dp)
        )
        IconButton(
            onClick = onNextMonth,
            colors = iconButtonColors(
                contentColor = Color.Black,
                containerColor = Color.Transparent)
        ){
            Icon(modifier = Modifier.size(48.dp),
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Previous Month"

            )
        }
    }
}
@SuppressLint("NewApi")
@Preview
@Composable
fun CalendarHeaderPreview() {
    CalendarHeader(displayedMonth = YearMonth.now(), onPreviousMonth = {}, onNextMonth = {}, onTitleClick = {})
}