package com.example.mybetapp.presentation

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybetapp.domain.repository.SportsRepository
import com.example.mybetapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SportsViewModel @Inject constructor(
    private val repository: SportsRepository
) : ViewModel() {

    var state by mutableStateOf(SportsState())
    private var countDownTimer: CountDownTimer? = null

    fun loadSportsInfo() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            when (val result = repository.getSportsData()) {
                is Resource.Error -> {
                    state = state.copy(
                        sportInfo = null,
                        isLoading = false,
                        error = result.message
                    )
                }
                is Resource.Success -> {
                    state = state.copy(
                        sportInfo = result.data,
                        isLoading = false,
                        error = null
                    )
                }
            }
        }
    }

    fun onFavouriteClicked(sportId: String, eventId: String, currentEventState: Boolean) {
        state = state.copy(sportInfo = state.sportInfo?.map { sport ->
            if (sport.sportId == sportId) {
                sport.copy(events = sport.events.map { event ->
                    if (event.eventId == eventId) {
                        event.copy(isFavourite = !currentEventState)
                    } else {
                        event
                    }
                })
            } else {
                sport
            }
        })

    }
}