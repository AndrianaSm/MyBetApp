package com.example.mybetapp.data.repository

import com.example.mybetapp.data.mappers.toSportDataMap
import com.example.mybetapp.data.remote.SportsApi
import com.example.mybetapp.domain.repository.SportsRepository
import com.example.mybetapp.domain.sports.SportInfo
import com.example.mybetapp.domain.util.Resource
import javax.inject.Inject

class SportsRepositoryImpl @Inject constructor(
    private val api: SportsApi
) : SportsRepository {
    override suspend fun getSportsData(): Resource<List<SportInfo>> {
        return try {
            Resource.Success(
                data = api.getSportsData().toSportDataMap()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "Something went wrong")
        }
    }
}