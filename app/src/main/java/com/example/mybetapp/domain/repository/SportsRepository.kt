package com.example.mybetapp.domain.repository

import com.example.mybetapp.domain.sports.SportInfo
import com.example.mybetapp.domain.util.Resource

interface SportsRepository {
    suspend fun getSportsData(): Resource<List<SportInfo>>
}