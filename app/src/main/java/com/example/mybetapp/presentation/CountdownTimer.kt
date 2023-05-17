package com.example.mybetapp.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mybetapp.ui.theme.Grey
import kotlinx.coroutines.channels.ticker

@Composable
fun CountdownTimer(eventStartDateSeconds: Long) {
    var currentTimeSeconds by remember { mutableStateOf(System.currentTimeMillis() / 1000) }
    val countdownText = remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        val ticker = ticker(delayMillis = 1000, initialDelayMillis = 0)
        for (event in ticker) {
            currentTimeSeconds = System.currentTimeMillis() / 1000
            val remainingSeconds = eventStartDateSeconds - currentTimeSeconds
            if (remainingSeconds > 0) {
                val formattedTime = formatTime(remainingSeconds)
                countdownText.value = formattedTime
            } else {
                countdownText.value = "past event"
                ticker.cancel()
            }
        }
    }

    Column(
        modifier = Modifier
            .border(
                BorderStroke(1.dp, Grey), MaterialTheme.shapes.small
            )
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = countdownText.value,
            style = MaterialTheme.typography.caption,
            textAlign = TextAlign.Center,
            color = Grey,
        )
    }
}

//
//private fun formatTime(remainingSeconds: Long): String {
//    val secondsInMinute = 60
//    val secondsInHour = 3600
//    val secondsInDay = 86400
//
//    val hours = remainingSeconds / secondsInHour
//    val minutes = (remainingSeconds % secondsInHour) / secondsInMinute
//    val seconds = remainingSeconds % secondsInMinute
//
//    if (remainingSeconds >= secondsInDay) {
//        return "${hours.toString().padStart(2, '0')}:${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}"
//    }
//
//    return if (hours > 0) {
//        "$hours hours"
//    } else if (minutes > 0) {
//        "$minutes minutes"
//    } else {
//        "$seconds seconds"
//    }
//}
private fun formatTime(remainingSeconds: Long): String {
    val secondsInMinute = 60
    val secondsInHour = 3600
    val secondsInDay = 86400
    val secondsInMonth = 2592000

    val months = remainingSeconds / secondsInMonth
    val days = (remainingSeconds % secondsInMonth) / secondsInDay
    val hours = (remainingSeconds % secondsInDay) / secondsInHour
    val minutes = (remainingSeconds % secondsInHour) / secondsInMinute
    val seconds = remainingSeconds % secondsInMinute

    return when {
        remainingSeconds >= secondsInMonth -> "in $months months"
        remainingSeconds >= secondsInDay -> "in $days days"
        else -> "${hours.toString().padStart(2, '0')}:${
            minutes.toString().padStart(2, '0')
        }:${seconds.toString().padStart(2, '0')}"
    }
}


@Preview
@Composable
fun rer() {
    CountdownTimer(1687668420)
}