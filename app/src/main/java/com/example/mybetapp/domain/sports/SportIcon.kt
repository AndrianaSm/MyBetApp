package com.example.mybetapp.domain.sports

import androidx.annotation.DrawableRes
import com.example.mybetapp.R

sealed class SportIcon(
    @DrawableRes val iconRes: Int,
    val contentDescription: String
) {
    object Soccer : SportIcon(
        iconRes = R.drawable.soccer,
        contentDescription = "soccer"
        )

    object Basketball : SportIcon(
        iconRes = R.drawable.basketball,
        contentDescription = "basketball"

        )

    object BeachVolleyBall : SportIcon(
        iconRes = R.drawable.soccer,
        contentDescription = "beach volleyball"
    )

    object ESports : SportIcon(
        iconRes = R.drawable.esports,
        contentDescription = "e sports"
    )

    object HandBall : SportIcon(
        iconRes = R.drawable.handball,
        contentDescription = "handball"
    )

    object TableTennis : SportIcon(
        iconRes = R.drawable.table_tennis,
        contentDescription = "table tennis"
    )

    object Tennis : SportIcon(
        iconRes = R.drawable.tennis,
        contentDescription = "tennis"
    )
}