package com.quanle.weatherapp

sealed class Screen(val route: String) {
    object WeatherListScreen: Screen("weather_list_screen")
}
