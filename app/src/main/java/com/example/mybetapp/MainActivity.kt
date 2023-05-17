package com.example.mybetapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.mybetapp.presentation.SportCard
import com.example.mybetapp.presentation.SportsViewModel
import com.example.mybetapp.ui.theme.DarkBlue
import com.example.mybetapp.ui.theme.MyBetAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel: SportsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadSportsInfo()
        setContent {
            MyBetAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = DarkBlue
                ) {
//                    Text(text = viewModel.state.error ?: viewModel.state.sportInfo.toString())
                    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                        viewModel.state.sportInfo?.forEach {
                            SportCard(sportInfo = it)
                        }
                    }
                }
            }
        }
    }
}

