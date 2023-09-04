package ru.thbank.thb_currency_app.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMainStateUseCase(
    private val repository: ICurrencyRepository
) {
    suspend fun execute(): Flow<MainState> = flow {
        repository.getMainState().collect{
            emit(it)
        }
    }
}