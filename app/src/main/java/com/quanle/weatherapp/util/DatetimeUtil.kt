package com.quanle.weatherapp.util


import com.quanle.weatherapp.common.Constants
import java.text.SimpleDateFormat
import java.util.*


class DatetimeUtil {

    companion object {
        fun getDate(dateLong: Long, format: String = Constants.DATE_FORMAT): String {
            return Calendar.getInstance().apply {
                timeInMillis = dateLong * 1000L
            }.run {
                val dateFormat = SimpleDateFormat(format)
                dateFormat.format(this.time)
            }
        }
        fun changeTemp(x: Double, y: Double): Int {
            return ((x + y) / 2).toInt()
        }
    }


}