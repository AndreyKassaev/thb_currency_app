package ru.thbank.thb_currency_app.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface ICurrencyRepositoryFlow {
    suspend fun getAllCurrencyDataFlow(): Flow<List<CurrencyEntity>>
}