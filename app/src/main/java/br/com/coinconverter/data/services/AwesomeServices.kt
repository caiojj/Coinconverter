package br.com.coinconverter.data.services

import br.com.coinconverter.data.module.ExchangeResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AwesomeServices {
    @GET("/json/last/{coins}")
    suspend fun getExchangeValue(@Path("coins") coins: String) : ExchangeResponse
}