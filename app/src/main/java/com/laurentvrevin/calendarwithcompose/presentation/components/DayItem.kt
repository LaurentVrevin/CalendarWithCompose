package com.laurentvrevin.calendarwithcompose.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun DayItem(text: String, isToday: Boolean = false, isGray: Boolean = false) {
    Text(
        text = text,
        color = when {
            isToday -> MaterialTheme.colorScheme.onPrimary
            isGray -> MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
            else -> MaterialTheme.colorScheme.onSurface
        },
        textAlign = TextAlign.Center,
        modifier = Modifier
            .size(40.dp)
            .background(
                if (isToday) MaterialTheme.colorScheme.secondaryContainer else Color.Transparent
            )
    )
}