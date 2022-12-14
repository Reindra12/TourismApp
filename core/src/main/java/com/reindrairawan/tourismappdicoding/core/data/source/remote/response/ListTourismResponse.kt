package com.reindrairawan.tourismappdicoding.core.data.source.remote.response

import com.reindrairawan.tourismappdicoding.core.data.source.remote.response.TourismResponse
import com.google.gson.annotations.SerializedName

data class ListTourismResponse(
    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("places")
    val places: List<TourismResponse>
)
