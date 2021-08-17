package br.com.coinconverter.data.repository

import br.com.coinconverter.core.exceptions.RemoteException
import br.com.coinconverter.data.database.AppDataBase
import br.com.coinconverter.data.module.ErrorResponse
import br.com.coinconverter.data.module.ExchangeResponseValue
import br.com.coinconverter.data.services.AwesomeServices
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class CoinRepositoryImp (
    appDataBase: AppDataBase,
    private val service: AwesomeServices
        ): CoinRepository {

    private val dao = appDataBase.exchangeDao()

    override suspend fun getExchangeValue(coins: String) = flow {
        try {
            val exchangeValue = service.getExchangeValue(coins)
            val exchange = exchangeValue.values.first()
            emit(exchange)
        } catch (e: HttpException) {
            val json = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(json, ErrorResponse::class.java)
            throw RemoteException(errorResponse.message)
        }
    }

    override suspend fun save(exchange: ExchangeResponseValue) {
        dao.save(exchange)
    }

    override fun list(): Flow<List<ExchangeResponseValue>> {
        return dao.findAll()
    }
}