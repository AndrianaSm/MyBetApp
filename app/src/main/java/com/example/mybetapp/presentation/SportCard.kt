package com.example.mybetapp.presentation

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mybetapp.R
import com.example.mybetapp.domain.sports.EventData
import com.example.mybetapp.domain.sports.SportInfo
import com.example.mybetapp.ui.theme.DarkBlue
import com.example.mybetapp.ui.theme.LighBlue
import com.example.mybetapp.ui.theme.LighGrey

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SportCard(
    modifier: Modifier = Modifier,
    sportInfo: SportInfo,
    onFavouriteClicked: (String, String, Boolean) -> Unit
) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if (expandedState) 180f else 0f)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    delayMillis = 300, easing = LinearOutSlowInEasing
                )
            )
            .clickable { expandedState = !expandedState }) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            //Sport Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(LighBlue)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Image(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(id = sportInfo.sportIcon),
                    contentDescription = "sport"
                )

                Text(
                    text = sportInfo.sportTitle,
                    color = LighGrey,
                    style = MaterialTheme.typography.body1
                )

                IconButton(modifier = Modifier.rotate(rotationState),
                    onClick = { expandedState = !expandedState }) {
                    Icon(
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(id = R.drawable.arrow),
                        tint = LighGrey,
                        contentDescription = "drop down"
                    )
                }
            }

            // expandable vertical scrollable events
            if (expandedState) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(DarkBlue)
                        .horizontalScroll(rememberScrollState())
                ) {
                    sportInfo.events.forEach { event ->
                        EventsRow(
                            eventData = event,
                            modifier = Modifier
                                .padding(8.dp)
                                .widthIn(max = 100.dp),
                            onFavouriteClicked = {
                                onFavouriteClicked(
                                    sportInfo.sportId,
                                    event.eventId,
                                    event.isFavourite
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SportRowPreview() {
    SportCard(
        sportInfo = SportInfo(
            events = listOf(
                EventData(
                    time = 1234,
                    isFavourite = true,
                    player1 = "Olympiacos",
                    player2 = "PAOK",
                    eventId = ""
                )
            ), sportTitle = "Soccer", sportIcon = R.drawable.soccer
        ),
        onFavouriteClicked = { _, _, _ -> }
    )
}