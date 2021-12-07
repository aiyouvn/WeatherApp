package com.quanle.weatherapp.domain.model

import com.google.gson.annotations.SerializedName
import com.quanle.weatherapp.data.remote.dto.*

data class Weather(
    val dt: Long,
    val sunrise: Long,
    val sunset: Long,
    val temp: Temp,
    @SerializedName("feels_like")
    val feelsLike: FeelsLike,
    val pressure: Long,
    val humidity: Long,
    val weather: List<Weathers>,
    val speed: Double,
    val deg: Long,
    val gust: Double,
    val clouds: Long,
    val pop: Double,
    val rain: Double,
    val snow: Double? = null
)
