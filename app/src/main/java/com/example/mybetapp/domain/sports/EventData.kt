package com.example.mybetapp.domain.sports

import java.time.LocalDateTime

data class EventData(
    val time: Long,
    val isFavourite: Boolean,
    val title: String
)