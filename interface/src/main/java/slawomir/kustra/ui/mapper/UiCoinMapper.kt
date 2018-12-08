package slawomir.kustra.ui.mapper

interface UiCoinMapper<in P, out U> {

    fun mapFromPresentation(presentation: P): U
}