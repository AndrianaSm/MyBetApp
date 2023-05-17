package com.example.mybetapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import com.example.mybetapp.presentation.SportCard
import com.example.mybetapp.presentation.SportsViewModel
import com.example.mybetapp.ui.theme.DarkBlue
import com.example.mybetapp.ui.theme.MyBetAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: SportsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadSportsInfo()

        setContent {
            MyBetAppTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(DarkBlue)
                        .verticalScroll(rememberScrollState())
                ) {
                    viewModel.state.sportInfo?.forEach {
                        SportCard(
                            sportInfo = it,
                            onFavouriteClicked = { sportId, eventId, currentState ->
                                viewModel.onFavouriteClicked(sportId, eventId, currentState)
                            })
                    }
                }
            }
        }
    }
}


