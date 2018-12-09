package slawomir.kustra.presentation.mapper

import slawomir.kustra.data.model.listing.Coin
import slawomir.kustra.presentation.model.UiCoin
import javax.inject.Inject

class ViewMapper @Inject constructor()  : ViewCoinMapper<Coin, UiCoin> {

    override fun mapToViewCoin(type: Coin): UiCoin =
            UiCoin(type.id, type.name, type.symbol, type.price, type.volume24h, type.percentChange1h,
                    type.percentChange24h, type.percentChange7d, type.marketCap, type.isObserved)
}