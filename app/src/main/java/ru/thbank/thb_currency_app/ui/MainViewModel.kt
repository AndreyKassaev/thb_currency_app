package ru.thbank.thb_currency_app.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.thbank.thb_currency_app.data.CurrencyRepository
import ru.thbank.thb_currency_app.domain.CurrencyEntity
import ru.thbank.thb_currency_app.domain.GetCurrentDateUseCase
import ru.thbank.thb_currency_app.domain.GetCurrentTimeUseCase
import ru.thbank.thb_currency_app.domain.GetMainStateUseCase
import ru.thbank.thb_currency_app.domain.MainState
import java.lang.Exception

class MainViewModel(
    val getCurrentTimeUseCase: GetCurrentTimeUseCase,
    val getCurrentDateUseCase: GetCurrentDateUseCase,
    val getMainStateUseCase: GetMainStateUseCase
    ): ViewModel() {

    private val defaultCurrencyList = listOf(
        CurrencyEntity.USD(buyPrice = "100", sellPrice = "100"),
        CurrencyEntity.EUR(buyPrice = "100", sellPrice = "100"),
        CurrencyEntity.GBP(buyPrice = "100", sellPrice = "100")
    )

    private val defaultMainState = MainState.Loading

    private val _mainState: MutableStateFlow<MainState> = MutableStateFlow(this.defaultMainState)
    val mainState: StateFlow<MainState> = _mainState

    val currentTime: MutableStateFlow<String> = MutableStateFlow("13:13:13")
    val currentDate: MutableStateFlow<String> = MutableStateFlow("11.11.2013")

    init {
        this.getMainState()
        this.whatTimeIsIt()
        this.whatDateIsIt()
    }

    private fun getMainState(){
        viewModelScope.launch {
            getMainStateUseCase.execute().collect{
                _mainState.value = it
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
                val getCurrentTimeUseCase = GetCurrentTimeUseCase()
                val getCurrentDateUseCase = GetCurrentDateUseCase()
                val getMainStateUseCase = GetMainStateUseCase(repository = repository)

                return MainViewModel(
                    getCurrentTimeUseCase = getCurrentTimeUseCase,
                    getCurrentDateUseCase = getCurrentDateUseCase,
                    getMainStateUseCase = getMainStateUseCase
                ) as T
            }
        }
    }
}
