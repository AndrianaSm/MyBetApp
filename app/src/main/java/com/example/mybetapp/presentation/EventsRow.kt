package com.example.mybetapp.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mybetapp.R
import com.example.mybetapp.domain.sports.EventData
import com.example.mybetapp.ui.theme.LighGrey
import com.example.mybetapp.ui.theme.Yellow

@Composable
fun EventsRow(
    modifier: Modifier = Modifier,
    eventData: EventData,
    onFavouriteClicked: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier
                .size(24.dp)
                .clickable { onFavouriteClicked() },
            tint = if (eventData.isFavourite) Yellow else LighGrey,
            painter = painterResource(id = R.drawable.star),
            contentDescription = stringResource(R.string.favourite_icon_content_description)
        )
        Text(
            text = eventData.player1,
            color = LighGrey,
            style = MaterialTheme.typography.caption,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = eventData.player2,
            color = LighGrey,
            style = MaterialTheme.typography.caption,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        CountdownTimer(eventStartDateSeconds = eventData.time)

    }
}

@Preview
@Composable
fun EventsRowPreview() {
    EventsRow(
        eventData = EventData(
            eventId = "",
            time = 1683102780,
            isFavourite = true,
            player2 = "PAOK",
            player1 = "OSFP"
        ), onFavouriteClicked = { }
    )
}