package ru.thbank.thb_currency_app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.thbank.thb_currency_app.data.CurrencyRepository
import ru.thbank.thb_currency_app.domain.CurrencyEntity
import ru.thbank.thb_currency_app.domain.GetAllCurrencyDataFlowUseCase
import ru.thbank.thb_currency_app.domain.GetCurrentDateUseCase
import ru.thbank.thb_currency_app.domain.GetCurrentTimeUseCase

class MainViewModel(
    val getAllCurrencyDataFlowUseCase: GetAllCurrencyDataFlowUseCase,
    val getCurrentTimeUseCase: GetCurrentTimeUseCase,
    val getCurrentDateUseCase: GetCurrentDateUseCase
    ): ViewModel() {

    private val defaultCurrencyList = listOf(
        CurrencyEntity.USD(buyPrice = "100", sellPrice = "100"),
        CurrencyEntity.EUR(buyPrice = "100", sellPrice = "100"),
        CurrencyEntity.GBP(buyPrice = "100", sellPrice = "100")
    )

    private val _currencyListFlow: MutableStateFlow<List<CurrencyEntity>> = MutableStateFlow(this.defaultCurrencyList)
    val currencyListFlow: StateFlow<List<CurrencyEntity>> = _currencyListFlow

    val currentTime: MutableStateFlow<String> = MutableStateFlow("13:13:13")
    val currentDate: MutableStateFlow<String> = MutableStateFlow("11.11.2013")

    init {
        this.getCurrencyDataFlow()
        this.whatTimeIsIt()
        this.whatDateIsIt()
    }

    private fun getCurrencyDataFlow(){
        viewModelScope.launch {
            getAllCurrencyDataFlowUseCase.execute().collect{
                _currencyListFlow.value = it
            }
        }
    }

    private fun whatDateIsIt(){
        viewModelScope.launch {
            getCurrentDateUseCase.execute().collect{currentDate.value = it}
        }
    }
    private fun whatTimeIsIt(){
        viewModelScope.launch {
            getCurrentTimeUseCase.execute().collect{currentTime.value = it}
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val repository = CurrencyRepository()
                val getAllCurrencyDataFlowUseCase = GetAllCurrencyDataFlowUseCase(repository = repository)
                val getCurrentTimeUseCase = GetCurrentTimeUseCase()
                val getCurrentDateUseCase = GetCurrentDateUseCase()

                return MainViewModel(
                    getAllCurrencyDataFlowUseCase = getAllCurrencyDataFlowUseCase,
                    getCurrentTimeUseCase = getCurrentTimeUseCase,
                    getCurrentDateUseCase = getCurrentDateUseCase
                ) as T
            }
        }
    }
}
