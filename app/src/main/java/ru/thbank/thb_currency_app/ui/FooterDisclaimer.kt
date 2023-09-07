package ru.thbank.thb_currency_app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.thbank.thb_currency_app.ui.theme.ForestGreen

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
//            Text(
//                modifier = Modifier
//                    .padding(end = 16.dp),
//                text = "Не является публичной офертой",
//                color = Color.White,
//                fontWeight = FontWeight.Medium,
//                fontFamily = montserratFamily
//            )
        }
    }

}