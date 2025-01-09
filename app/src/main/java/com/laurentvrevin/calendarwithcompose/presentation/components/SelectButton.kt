package com.laurentvrevin.calendarwithcompose.presentation.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SelectButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "Select")
    }
}