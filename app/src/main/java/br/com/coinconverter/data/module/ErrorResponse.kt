package br.com.coinconverter.data.module

data class ErrorResponse(
    val status: Long,
    val code: String,
    val message: String
)
