package ru.thbank.thb_currency_app.domain

import kotlinx.coroutines.flow.Flow

interface ICurrencyRepository {
    suspend fun getMainState(): Flow<MainState>

}