package com.quanle.weatherapp.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.quanle.weatherapp.domain.model.Weather

data class ListElement (
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

fun ListElement.toWeather(): Weather {
    return Weather(
        dt = dt,
        sunrise = sunrise,
        sunset = sunset,
        temp = temp,
        feelsLike=feelsLike,
        pressure=pressure,
        humidity= humidity,
        weather=weather,
        speed=speed,
        deg=deg,
        gust=gust,
        clouds=clouds,
        pop=pop,
        rain=rain,
        snow=snow
    )
}