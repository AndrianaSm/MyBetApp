package com.example.mybetapp.domain.sports

import androidx.annotation.DrawableRes

data class SportInfo(
    val sportId: String = "",
    @DrawableRes val sportIcon: Int,
    val sportTitle: String,
    val events: List<EventData>
)
