package com.example.mybetapp.data.mappers

import com.example.mybetapp.data.remote.SportsDto
import com.example.mybetapp.domain.sports.EventData
import com.example.mybetapp.domain.sports.SportIcon
import com.example.mybetapp.domain.sports.SportInfo

fun List<SportsDto>.toSportDataMap(): List<SportInfo> {
    return map {
        SportInfo(
            sportIcon = getSportDrawable(it.id.orEmpty()),
            sportTitle = it.description.orEmpty(),
            events = it.events.map { event ->
                EventData(
                    isFavourite = false,
                    player1 = event.description?.substringBefore("-").orEmpty(),
                    player2 = event.description?.substringAfter("-").orEmpty(),
                    time = event.timestamp ?: 0,
                    eventId = event.id.orEmpty()
                )
            })
    }
}

fun getSportDrawable(id: String): SportIcon? {
    return when (id) {
        "FOOT" -> SportIcon.Soccer
        "BASK" -> SportIcon.Basketball
        "TENN" -> SportIcon.Tennis
        "TABL" -> SportIcon.TableTennis
        "ESPS" -> SportIcon.ESports
        "HAND" -> SportIcon.HandBall
        "BCHV" -> SportIcon.BeachVolleyBall
        else -> null
    }
}