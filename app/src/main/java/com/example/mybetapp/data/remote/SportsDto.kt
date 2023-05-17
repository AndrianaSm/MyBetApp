package com.example.mybetapp.data.remote

import com.google.gson.annotations.SerializedName

data class SportsDto(
    @SerializedName("i") var id: String? = null,
    @SerializedName("d") var description: String? = null,
    @SerializedName("e") var events: ArrayList<Event> = arrayListOf()
)

data class Event(
   @SerializedName("d") var description: String? = null,
   @SerializedName("i") var id: String? = null,
   @SerializedName("si") var sportId: String? = null,
   @SerializedName("sh") var sh: String? = null,
   @SerializedName("tt") var timestamp: Long? = null

)