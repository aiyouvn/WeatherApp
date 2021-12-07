package com.quanle.weatherapp.data.remote.dto

data class Weathers (
    val id: Long,
    val main: String,
    val description: String,
    val icon: String
)