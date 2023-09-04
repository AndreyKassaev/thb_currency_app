package ru.thbank.thb_currency_app.domain

sealed interface MainState{
    class Success(val CurrencyList: List<CurrencyEntity>): MainState
    object Loading: MainState
    object Error: MainState
}
