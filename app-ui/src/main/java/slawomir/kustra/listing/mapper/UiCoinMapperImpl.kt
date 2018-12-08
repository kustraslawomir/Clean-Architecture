package slawomir.kustra.listing.mapper

import slawomir.kustra.presentation.model.PresentationCoin
import slawomir.kustra.listing.model.UiCoin

open class UiCoinMapperImpl : UiCoinMapper<PresentationCoin, UiCoin> {

    override fun mapFromPresentation(presentation: PresentationCoin): UiCoin = UiCoin(presentation.id, presentation.name, presentation.symbol, presentation.price,
            presentation.volume24h, presentation.percentChange1h, presentation.percentChange24h,
            presentation.percentChange7d, presentation.marketCap, presentation.isObserved)
}