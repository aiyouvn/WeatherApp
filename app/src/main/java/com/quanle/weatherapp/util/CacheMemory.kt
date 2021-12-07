package com.quanle.weatherapp.util

import com.quanle.weatherapp.domain.model.Weather

object CacheMemory {
    val cacheResult = mutableMapOf<String,List<Weather>>()
}