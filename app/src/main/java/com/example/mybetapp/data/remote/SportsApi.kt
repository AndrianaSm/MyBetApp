package com.example.mybetapp.data.remote

import retrofit2.http.GET

interface SportsApi {
    @GET("sports")
    suspend fun getSportsData(): List<SportsDto>
}