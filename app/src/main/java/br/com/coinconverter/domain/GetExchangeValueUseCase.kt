package br.com.coinconverter.domain

import br.com.coinconverter.core.UseCase
import br.com.coinconverter.data.module.ExchangeResponseValue
import br.com.coinconverter.data.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class GetExchangeValueUseCase(
    private val repository: CoinRepository
) : UseCase<String, ExchangeResponseValue>() {
    override suspend fun execute(param: String): Flow<ExchangeResponseValue> {
        return repository.getExchangeValue(param)
    }
}