package ru.thbank.thb_currency_app.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.thbank.thb_currency_app.ui.theme.ForestGreen

class CurrencyBuySell {
    @Composable
    fun execute(){

        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .weight(1f)
                    .drawWithContent {
                        drawContent()
                        drawLine(
                            color = ForestGreen,
                            start = Offset(size.width, 0f),
                            end = Offset(size.width, size.height),
                            strokeWidth = 3f
                        )
                    },
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Валюта",
                    color = ForestGreen,
                    fontSize = 54.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .weight(1f),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Покупка",
                    color = ForestGreen,
                    fontSize = 54.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .weight(1f),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Продажа",
                    color = ForestGreen,
                    fontSize = 54.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}