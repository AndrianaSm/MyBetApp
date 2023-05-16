package com.example.mybetapp.presentation

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
}