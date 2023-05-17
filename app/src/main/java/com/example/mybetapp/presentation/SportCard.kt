package com.example.mybetapp.presentation

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mybetapp.R
import com.example.mybetapp.domain.sports.SportInfo
import com.example.mybetapp.ui.theme.DarkBlue
import com.example.mybetapp.ui.theme.LighBlue
import com.example.mybetapp.ui.theme.LighGrey
import com.example.mybetapp.ui.theme.Yellow

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SportCard(
    modifier: Modifier = Modifier, sportInfo: SportInfo
) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if (expandedState) 180f else 0f)
    Card(modifier = Modifier
        .fillMaxWidth()
        .animateContentSize(
            animationSpec = tween(
                delayMillis = 300, easing = LinearOutSlowInEasing
            )
        ), shape = RoundedCornerShape(4.dp), onClick = { expandedState = !expandedState }) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
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
                Text(text = sportInfo.sportTitle, color = LighGrey)
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
            if (expandedState) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(DarkBlue)
                        .horizontalScroll(rememberScrollState())
                ) {
                    sportInfo.events.forEach {
                        Column(
                            modifier = Modifier
                                .padding(8.dp)
                                .widthIn(max = 100.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            horizontalAlignment = CenterHorizontally
                        ) {
                            Text(
                                modifier = Modifier
                                    .border(
                                        BorderStroke(1.dp, LighGrey), RoundedCornerShape(4.dp)
                                    )
                                    .padding(8.dp),
                                text = "HH:MM:SS",
                                fontSize = 12.sp,
                                color = LighGrey
                            )
                            Icon(
                                modifier = Modifier.size(24.dp),
                                tint = if (it.isFavourite) Yellow else LighGrey,
                                painter = painterResource(id = R.drawable.star),
                                contentDescription = "favourite"
                            )
                            Text(
                                text = it.player1,
                                color = LighGrey,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = it.player2,
                                color = LighGrey,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )

                        }
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
            events = emptyList(), sportTitle = "Soccer", sportIcon = R.drawable.soccer
        )
    )
}