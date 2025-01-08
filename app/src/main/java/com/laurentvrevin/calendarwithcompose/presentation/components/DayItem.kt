package com.laurentvrevin.calendarwithcompose.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun DayItem(text: String, isToday: Boolean = false, isGray: Boolean = false) {

    val modifier = Modifier
        .size(40.dp)
        .let {
            if (isToday) {
                it.clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondaryContainer)
            } else {
                it.background(Color.Transparent)
            }
        }
        .wrapContentSize(Alignment.Center)


    Text(
        text = text,
        color = when {
            isToday -> MaterialTheme.colorScheme.onPrimary
            isGray -> MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
            else -> MaterialTheme.colorScheme.onSurface 
        },
        textAlign = TextAlign.Center,
        fontWeight = if (isGray) FontWeight.Normal else FontWeight.Bold,
        modifier = modifier
    )
}