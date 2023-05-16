package com.example.mybetapp.presentation

import com.example.mybetapp.domain.sports.SportInfo

data class SportsState(
    val sportInfo: SportInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)