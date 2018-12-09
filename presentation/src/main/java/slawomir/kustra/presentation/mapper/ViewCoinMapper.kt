package slawomir.kustra.presentation.mapper

interface ViewCoinMapper <in D, out U>  {

    fun mapToViewCoin(type : D) : U
}