package com.laurentvrevin.calendarwithcompose

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.laurentvrevin.calendarwithcompose.presentation.screen.CalendarView
import com.laurentvrevin.calendarwithcompose.presentation.ui.theme.CalendarWithComposeTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalendarWithComposeTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 48.dp)
                ) { innerPadding ->
                    CalendarView(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

