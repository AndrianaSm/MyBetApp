package com.example.mybetapp.data.mappers

import androidx.annotation.DrawableRes
import com.example.mybetapp.R
import com.example.mybetapp.data.remote.SportsDto
import com.example.mybetapp.domain.sports.EventData
import com.example.mybetapp.domain.sports.SportInfo

fun List<SportsDto>.toSportDataMap(): List<SportInfo> {
    return map {
        SportInfo(
            sportIcon = getSportDrawable(it.id.orEmpty()),
            sportTitle = it.description.orEmpty(),
            events = it.events.map { event ->
                EventData(
                    isFavourite = false,
                    title = event.sh.orEmpty(),
                    time = event.tt ?: 0,
                )
            })
    }
}

@DrawableRes
fun getSportDrawable(id: String): Int {
    return when (id) {
        "FOOT" -> R.drawable.soccer
        "BASK" -> R.drawable.basketball
        "TENN" -> R.drawable.tennis
        "TABL" -> R.drawable.table_tennis
        "ESPS" -> R.drawable.esports
        "HAND" -> R.drawable.handball
        "BCHV" -> R.drawable.beach_volleyball
        else -> R.drawable.question
    }
}