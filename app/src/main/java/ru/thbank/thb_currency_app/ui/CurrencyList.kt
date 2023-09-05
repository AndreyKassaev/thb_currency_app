package ru.thbank.thb_currency_app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.thbank.thb_currency_app.R
import ru.thbank.thb_currency_app.domain.CurrencyEntity
import ru.thbank.thb_currency_app.domain.MainState
import ru.thbank.thb_currency_app.ui.theme.ForestGreen
import ru.thbank.thb_currency_app.ui.theme.ForestGreenWithOpacity
import java.lang.Error

class CurrencyList(val viewModel: MainViewModel) {
    
    lateinit var USD: CurrencyEntity.USD
    lateinit var EUR: CurrencyEntity.EUR
    lateinit var GBP: CurrencyEntity.GBP
    
    @Composable
    fun execute(){
//        val currencyList = viewModel.currencyListFlow.collectAsState().value
        val mainState = viewModel.mainState.collectAsState().value



        when(mainState){
            is MainState.Success -> {
                Success(currencyList = mainState.CurrencyList)
            }
            is MainState.Loading -> {

            }
            is MainState.Error -> {

            }
        }

        
    }

    
    @Composable
    fun Success(currencyList: List<CurrencyEntity>){
        for (currency in currencyList){
            when(currency){
                is CurrencyEntity.USD -> {
                    USD = currency
                }
                is CurrencyEntity.EUR -> {
                    EUR = currency
                }
                is CurrencyEntity.GBP -> {
                    GBP = currency
                }
            }
        }
        Column(Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(ForestGreenWithOpacity)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
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
                    contentAlignment = Alignment.CenterStart
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier
                            .weight(1F),
                            contentAlignment = Alignment.Center
                        )
                        {
                            Image(
                                painterResource(id = R.drawable.usd),
                                contentDescription = "USA",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(start = 24.dp)
                            )
                        }
                        Box(modifier = Modifier
                            .weight(2F),
                            contentAlignment = Alignment.Center
                        )
                        {
                            Column(
                                modifier = Modifier
                                    .padding(start = 8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Доллар США",
                                    color = ForestGreen,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    text = "USD",
                                    color = ForestGreen,
                                    fontSize = 32.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = USD.buyPrice,
                        color = ForestGreen,
                        fontSize = 84.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = USD.sellPrice,
                        color = ForestGreen,
                        fontSize = 84.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
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
                    contentAlignment = Alignment.CenterStart
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier
                            .weight(1F),
                            contentAlignment = Alignment.Center){
                            Image(
                                painterResource(id = R.drawable.eur),
                                contentDescription = "EUR",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(start = 24.dp)
                            )
                        }
                        Box(modifier = Modifier
                            .weight(2F),
                            contentAlignment = Alignment.Center){
                            Column(
                                modifier = Modifier
                                    .padding(start = 8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Евро",
                                    color = ForestGreen,
                                    fontSize = 34.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    text = "EUR",
                                    color = ForestGreen,
                                    fontSize = 32.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = EUR.buyPrice,
                        color = ForestGreen,
                        fontSize = 84.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = EUR.sellPrice,
                        color = ForestGreen,
                        fontSize = 84.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(ForestGreenWithOpacity)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
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
                    contentAlignment = Alignment.CenterStart
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1F),
                            contentAlignment = Alignment.Center
                        ){
                            Image(
                                painterResource(id = R.drawable.gbp),
                                contentDescription = "GBP",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(start = 24.dp)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .weight(2F),
                            contentAlignment = Alignment.Center
                        ){
                            Column(
                                modifier = Modifier
                                    .padding(start = 8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Фунт стерлингов",
                                    color = ForestGreen,
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    text = "GBP",
                                    color = ForestGreen,
                                    fontSize = 32.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = GBP.buyPrice,
                        color = ForestGreen,
                        fontSize = 84.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = GBP.sellPrice,
                        color = ForestGreen,
                        fontSize = 84.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }

}