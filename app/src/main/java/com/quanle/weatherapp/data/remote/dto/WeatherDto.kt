package com.quanle.weatherapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("city")
    val city: City,
    @SerializedName("cod")
    val cod: String,
    @SerializedName("message")
    val message: Double,
    @SerializedName("cnt")
    val cnt: Int,
    @SerializedName("list")
    val list: List<ListElement>
)
