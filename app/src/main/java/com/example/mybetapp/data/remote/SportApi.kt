package com.example.mybetapp.data.remote

import retrofit2.http.GET

interface SportApi {
    @GET("sports")
    suspend fun getSportsData(): SportsDto
}