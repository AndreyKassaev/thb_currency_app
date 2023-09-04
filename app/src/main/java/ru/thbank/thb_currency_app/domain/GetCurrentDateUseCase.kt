package ru.thbank.thb_currency_app.domain

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.text.SimpleDateFormat
import java.util.Date

class GetCurrentDateUseCase {
    fun execute(): Flow<String> = flow {
        val sdf = SimpleDateFormat("dd.MM.yyyy")
        while(true){
            emit(sdf.format(Date()))
            delay(1000L*60*60)
        }
    }
}