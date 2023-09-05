package ru.thbank.thb_currency_app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ru.thbank.thb_currency_app.ui.theme.ForestGreen
import ru.thbank.thb_currency_app.ui.theme.montserratFamily

class FooterDisclaimer {
    @Composable
    fun execute(){
        Row(
            modifier = Modifier
                .background(ForestGreen)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                modifier = Modifier
                    .padding(end = 16.dp),
                text = "Не является публичной офертой",
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontFamily = montserratFamily
            )
        }
    }

}