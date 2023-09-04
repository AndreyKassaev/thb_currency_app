package ru.thbank.thb_currency_app.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import ru.thbank.thb_currency_app.domain.CurrencyEntity
import ru.thbank.thb_currency_app.domain.ICurrencyRepository
import ru.thbank.thb_currency_app.domain.MainState

class CurrencyRepository: ICurrencyRepository {
 override suspend fun getMainState(): Flow<MainState> = flow {
        while (true){
            try {
                lateinit var list: List<CurrencyEntity>
                lateinit var mainState: MainState
                withContext(Dispatchers.IO) {
                    val HTMLDocument: Document = Jsoup.connect("https://www.thbank.ru/currency/").get()
                    val HTMLDocumentElements: Elements =
                        HTMLDocument.getElementsByClass("currency-item")
                    var currencyEntityList = mutableListOf<CurrencyEntity>()
                    for (element in HTMLDocumentElements) {
                        val pattern = Regex("""USD|EUR|GBP""").find(element.toString())
                        when (pattern?.value) {
                            "USD" -> {
                                currencyEntityList.add(
                                    CurrencyEntity.USD(
                                        buyPrice = getCurrencyBuyPrice(
                                            element
                                        ), sellPrice = getCurrencySellPrice(element)
                                    )
                                )
                            }

                            "EUR" -> {
                                currencyEntityList.add(
                                    CurrencyEntity.EUR(
                                        buyPrice = getCurrencyBuyPrice(
                                            element
                                        ), sellPrice = getCurrencySellPrice(element)
                                    )
                                )
                            }

                            "GBP" -> {
                                currencyEntityList.add(
                                    CurrencyEntity.GBP(
                                        buyPrice = getCurrencyBuyPrice(
                                            element
                                        ), sellPrice = getCurrencySellPrice(element)
                                    )
                                )
                            }
                        }
                    }
                    currencyEntityList.let {
                        mainState = MainState.Success(CurrencyList = it)
                    }
                }
                emit(mainState)
                delay(60_000L)
            }catch (e: Exception){
                emit(MainState.Error)
                delay(10_000L)
            }
        }
    }

    fun getCurrencyBuyPrice(element: Element): String {
        val buyElement = element.getElementsByClass("currency-item-buy")
        val pattern = Regex("""(\d+),(\d+)""").find(buyElement.toString())
        val result = pattern?.value
        return result!!
    }

    fun getCurrencySellPrice(element: Element): String {
        val buyElement = element.getElementsByClass("currency-item-sell")
        val pattern = Regex("""(\d+),(\d+)""").find(buyElement.toString())
        val result = pattern?.value
        return result!!
    }

}