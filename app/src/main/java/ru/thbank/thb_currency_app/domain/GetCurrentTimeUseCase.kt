package ru.thbank.thb_currency_app.domain

import android.os.SystemClock.sleep
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone

class GetCurrentTimeUseCase {
    fun execute(): Flow<String> = flow {
        val sdf = SimpleDateFormat("HH:mm:ss")
//        sdf.setTimeZone(TimeZone.getTimeZone("GMT+4:00"))
        while(true){
            emit(sdf.format(Date()))
            delay(1000L)
        }
    }
}