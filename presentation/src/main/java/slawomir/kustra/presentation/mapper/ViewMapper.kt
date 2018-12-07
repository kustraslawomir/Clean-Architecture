package slawomir.kustra.presentation.mapper

import slawomir.kustra.domain.model.listing.Coin
import slawomir.kustra.presentation.model.ViewCoinModel

class ViewMapper : ViewCoinMapper<Coin, ViewCoinModel> {

    override fun mapToViewCoin(type: Coin): ViewCoinModel =
            ViewCoinModel(type.id, type.name, type.symbol, type.price, type.volume24h, type.percentChange1h,
                    type.percentChange24h, type.percentChange7d, type.marketCap)
}