package ru.thbank.thb_currency_app.data

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
import ru.thbank.thb_currency_app.domain.ICurrencyRepositoryFlow

class CurrencyRepository: ICurrencyRepositoryFlow {

    override suspend fun getAllCurrencyDataFlow(): Flow<List<CurrencyEntity>> = flow {
        while (true){
            lateinit var list: List<CurrencyEntity>
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
                list = currencyEntityList
            }
            emit(list)
            delay(60_000L)
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