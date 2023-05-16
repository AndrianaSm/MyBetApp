package com.example.mybetapp.data.remote

import com.squareup.moshi.Json

data class SportsDto(
    @field:Json(name = "i") var id: String? = null,
    @field:Json(name = "d") var description: String? = null,
    @field:Json(name = "e") var events: ArrayList<Event> = arrayListOf()
)

data class Event(
    @field:Json(name = "d") var description: String? = null,
    @field:Json(name = "i") var id: String? = null,
    @field:Json(name = "si") var sportId: String? = null,
    @field:Json(name = "sh") var sh: String? = null,
    @field:Json(name = "tt") var tt: Long? = null

)