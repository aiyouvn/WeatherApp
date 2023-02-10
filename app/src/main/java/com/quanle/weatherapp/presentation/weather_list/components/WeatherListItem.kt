package com.quanle.weatherapp.presentation.weather_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.quanle.weatherapp.R
import com.quanle.weatherapp.common.Constants
import com.quanle.weatherapp.domain.model.Weather
import com.quanle.weatherapp.util.DatetimeUtil

@Composable
fun WeatherListItem(
    weather: Weather,
    onItemClick: (Weather) -> Unit,
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(weather) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(weather) }
                .padding(5.dp, 0.dp, 5.dp, 0.dp)
        ) {

            Text(
                text = String.format("%s %s ",context.getString(R.string.date_title),DatetimeUtil.getDate(weather.dt,Constants.DATE_FORMAT_1)),
                color = Color.Gray,
                fontStyle = FontStyle.Normal,
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = String.format("%s %s%s",context.getString(R.string.average_temperature_title),DatetimeUtil.changeTemp(weather.temp.max,weather.temp.min),"\u2103"),
                color = Color.Gray,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.body1,
            )
            Text(
                text = String.format("%s %s ",context.getString(R.string.pressure_title),weather.pressure),
                color = Color.Gray,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.body1,
            )
            Text(
                text = String.format("%s %s%s",context.getString(R.string.humidity_title),weather.humidity,"%"),
                color = Color.Gray,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.body1,
            )
            Text(
                text = String.format("%s %s ",context.getString(R.string.description_title),weather.weather[0].description),
                color = Color.Gray,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.body1,
            )
        }

        Divider(modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 8.dp).background(Color.Gray))
    }
}