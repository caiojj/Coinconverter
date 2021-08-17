package br.com.coinconverter.domain

import br.com.coinconverter.core.UseCase
import br.com.coinconverter.data.module.ExchangeResponseValue
import br.com.coinconverter.data.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class ListExchangeUseCase(
    private val repository: CoinRepository
) : UseCase.NoParam<List<ExchangeResponseValue>>() {
    override suspend fun execute(): Flow<List<ExchangeResponseValue>> {
        return repository.list()
    }
}