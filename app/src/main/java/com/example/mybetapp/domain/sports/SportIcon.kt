package com.example.mybetapp.domain.sports

import androidx.annotation.DrawableRes
import com.example.mybetapp.R

sealed class SportIcon(
    @DrawableRes val iconRes: Int
) {
    object Soccer : SportIcon(
        iconRes = R.drawable.soccer
    )
    object Basketball : SportIcon(
        iconRes = R.drawable.basketball
    )
    object BeachVolleyBall : SportIcon(
        iconRes = R.drawable.soccer
    )
    object ESports : SportIcon(
        iconRes = R.drawable.esports
    )
    object HandBall : SportIcon(
        iconRes = R.drawable.handball
    )
    object TableTennis : SportIcon(
        iconRes = R.drawable.table_tennis
    )
    object Tennis : SportIcon(
        iconRes = R.drawable.tennis
    )
}