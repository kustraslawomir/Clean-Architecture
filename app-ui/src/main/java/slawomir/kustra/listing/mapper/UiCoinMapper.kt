package slawomir.kustra.listing.mapper

interface UiCoinMapper<in P, out U> {

    fun mapFromPresentation(presentation: P): U
}