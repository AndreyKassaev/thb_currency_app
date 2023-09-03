package ru.thbank.thb_currency_app.domain

sealed class CurrencyEntity(){
    class USD(val buyPrice: String, val sellPrice: String): CurrencyEntity()
    class EUR(val buyPrice: String, val sellPrice: String): CurrencyEntity()
    class GBP(val buyPrice: String, val sellPrice: String): CurrencyEntity()
}
