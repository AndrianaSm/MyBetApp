package com.example.mybetapp.data.mappers

import androidx.annotation.DrawableRes
import com.example.mybetapp.R
import com.example.mybetapp.data.remote.SportsDto
import com.example.mybetapp.domain.sports.EventData
import com.example.mybetapp.domain.sports.SportInfo

fun SportsDto.toSportDataMap(): SportInfo {
    return SportInfo(
        sportIcon = getSportDrawable(id.orEmpty()),
        sportTitle = description.orEmpty(),
        events = events.map {
            EventData(
                isFavourite = false,
                title = it.sh.orEmpty(),
                time = it.tt ?: 0,
            )
        })

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