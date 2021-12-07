package com.quanle.weatherapp.presentation.weather_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.quanle.weatherapp.R
import com.quanle.weatherapp.presentation.weather_list.components.WeatherListItem

@Composable
fun WeatherListScreen(
    viewModel: WeatherListViewModel = hiltViewModel()
) {
    var state = viewModel.state.value
    val valueInput = viewModel.query.value
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    Column {
        TopAppBar(modifier = Modifier
            .background(MaterialTheme.colors.primary)) {
            Text(
                text = context.getString(R.string.weather_forecast_title),
                color = Color.White,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(10.dp,0.dp,0.dp,0.dp)
            )
        }
        TextField(
            value = valueInput,
            onValueChange = { newValue ->
                viewModel.onQueryChanged(newValue)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),

            keyboardActions = KeyboardActions(onSearch = {
                viewModel.getWeatherList(valueInput)
                focusManager.clearFocus()
            }),
            textStyle = TextStyle(color =  Color.Black, fontSize = 18.sp),
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            )
        Button(
            enabled = valueInput.length >= 3,
            onClick = {
                viewModel.getWeatherList(valueInput)
                focusManager.clearFocus()
            }, modifier = Modifier.padding(0.dp,10.dp,0.dp,10.dp)

        ) {
            Text(context.getString(R.string.get_weather_btn_title),  color = Color.Black, modifier = Modifier.padding(0.dp,5.dp,0.dp,5.dp))
        }
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.weathers) { weather ->
                    WeatherListItem(
                        weather = weather,
                        onItemClick = {
                            // Onclick Item
                        }
                    )
                }
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

