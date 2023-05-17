package com.example.mybetapp.domain.sports

data class SportInfo(
    val sportId: String = "",
    val sportIcon: SportIcon?,
    val sportTitle: String,
    val events: List<EventData>
)
