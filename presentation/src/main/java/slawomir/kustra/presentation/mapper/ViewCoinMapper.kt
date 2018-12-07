package slawomir.kustra.presentation.mapper

interface ViewCoinMapper<in D, out V> {

    fun mapToViewCoin(type : D) : V
}