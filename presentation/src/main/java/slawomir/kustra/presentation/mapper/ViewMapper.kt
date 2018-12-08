package slawomir.kustra.presentation.mapper

import slawomir.kustra.domain.model.listing.Coin
import slawomir.kustra.presentation.model.CoinPresentation

class ViewMapper : ViewCoinMapper<Coin, CoinPresentation> {

    override fun mapToViewCoin(type: Coin): CoinPresentation =
            CoinPresentation(type.id, type.name, type.symbol, type.price, type.volume24h, type.percentChange1h,
                    type.percentChange24h, type.percentChange7d, type.marketCap, type.isObserved)
}