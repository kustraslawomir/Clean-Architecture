package slawomir.kustra.presentation.mapper

import slawomir.kustra.domain.model.listing.Coin
import slawomir.kustra.presentation.model.PresentationCoin

class ViewMapper : ViewCoinMapper<Coin, PresentationCoin> {

    override fun mapToViewCoin(type: Coin): PresentationCoin =
            PresentationCoin(type.id, type.name, type.symbol, type.price, type.volume24h, type.percentChange1h,
                    type.percentChange24h, type.percentChange7d, type.marketCap, type.isObserved)
}