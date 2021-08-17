package br.com.coinconverter.data.repository

import br.com.coinconverter.data.module.ExchangeResponseValue
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    suspend fun getExchangeValue(coins: String): Flow<ExchangeResponseValue>

    suspend fun save(exchange: ExchangeResponseValue)

    fun list(): Flow<List<ExchangeResponseValue>>

}