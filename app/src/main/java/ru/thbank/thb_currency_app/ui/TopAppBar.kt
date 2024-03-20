package ru.thbank.thb_currency_app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import ru.thbank.thb_currency_app.R
import ru.thbank.thb_currency_app.domain.MainState
import ru.thbank.thb_currency_app.ui.theme.ForestGreen
import ru.thbank.thb_currency_app.ui.theme.montserratFamily

class TopAppBar(val viewModel: MainViewModel) {
    @Composable
    fun execute(){

        val currentTime = viewModel.currentTime.collectAsState().value
        val currentDate = viewModel.currentDate.collectAsState().value

        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(ForestGreen)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .drawWithContent {
                        drawContent()
                        drawLine(
                            color = Color.White,
                            start = Offset(size.width, 0f),
                            end = Offset(size.width, size.height),
                            strokeWidth = 3f
                        )
                    },
                contentAlignment = Alignment.Center
            ){
                Image(
                    painterResource(id = R.drawable.logo),
                    contentDescription = "Thbank logo",
                    modifier = Modifier
                        .fillMaxSize(1f)
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(1.0f),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "КУРСЫ ВАЛЮТ",
                    color = Color.White,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = montserratFamily,
                    textAlign = TextAlign.Center
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(1f),
                contentAlignment = Alignment.Center
            ){
                Column(
                    verticalArrangement =  Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = currentDate,
                        color = Color.White,
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = montserratFamily
                    )
                    Text(
                        text = currentTime,
                        color = Color.White,
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = montserratFamily
                    )
                }
            }
        }

    }
}