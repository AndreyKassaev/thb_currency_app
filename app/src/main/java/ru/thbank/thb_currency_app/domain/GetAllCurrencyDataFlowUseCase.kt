package ru.thbank.thb_currency_app.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class GetAllCurrencyDataFlowUseCase(
    private val repository: ICurrencyRepositoryFlow
) {
    suspend fun execute(): Flow<List<CurrencyEntity>> = flow {
        repository.getAllCurrencyDataFlow().collect{
            emit(it)
        }
    }
}