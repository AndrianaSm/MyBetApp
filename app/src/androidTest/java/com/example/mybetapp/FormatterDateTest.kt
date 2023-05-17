package com.example.mybetapp

import com.example.mybetapp.presentation.formatTime
import org.junit.Assert.assertEquals
import org.junit.Test

class FormatTimeTest {

    @Test
    fun formatTime_LessThan24Hours_ReturnsHHMMSS() {
        // Given
        val remainingSeconds = 12345L

        // When
        val formattedTime = formatTime(remainingSeconds)

        // Then
        assertEquals("03:25:45", formattedTime)
    }

    @Test
    fun formatTime_MoreThan24Hours_ReturnsDays() {
        // Given
        val remainingSeconds = 987654L

        // When
        val formattedTime = formatTime(remainingSeconds)

        // Then
        assertEquals("in 11 days", formattedTime)
    }

    @Test
    fun formatTime_MoreThan30Days_ReturnsMonths() {
        // Given
        val remainingSeconds = 2592001L

        // When
        val formattedTime = formatTime(remainingSeconds)

        // Then
        assertEquals("in 1 month", formattedTime)
    }
    @Test
    fun formatTime_MoreThan1Month_ReturnsMonths() {
        // Given
        val remainingSeconds = 6003001L

        // When
        val formattedTime = formatTime(remainingSeconds)

        // Then
        assertEquals("in 2 months", formattedTime)
    }
}
