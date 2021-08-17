package br.com.coinconverter.data.module

import java.util.*

enum class Coin(
    val locale: Locale
) {
    USD(Locale.US),
    BRL(Locale("pt", "BR")),
    CAD(Locale.CANADA),
    ARS(Locale("es", "AR"));

    companion object {
        fun getByName(name: String) = values().find { it.name == name } ?: BRL
    }

}