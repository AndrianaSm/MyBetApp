package com.example.mybetapp.domain.sports

data class EventData(
    val eventId: String,
    val time: Long,
    val isFavourite: Boolean,
    val player1: String,
    val player2: String

)