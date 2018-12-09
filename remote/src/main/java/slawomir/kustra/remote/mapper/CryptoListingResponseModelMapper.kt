package slawomir.kustra.remote.mapper

import slawomir.kustra.data.model.listing.Coin
import slawomir.kustra.remote.model.CryptoListingsResponse
import slawomir.kustra.remote.model.ResponseCoin
import javax.inject.Inject

class CryptoListingResponseModelMapper @Inject internal constructor() : ModelMapper<CryptoListingsResponse, List<Coin>> {

    override fun mapFromModel(model: CryptoListingsResponse): List<Coin> = mapData(model)

    private fun mapData(model: CryptoListingsResponse?): List<Coin> {
        val coinsEntities = mutableListOf<Coin>()

        if (model != null && model.data?.isNotEmpty() == true) {
            model.data?.forEach { coin -> coinsEntities.add(mapCoin(coin)) }
        }
        return coinsEntities
    }

    private fun mapCoin(coin: ResponseCoin) =
            Coin(coin.id,
                    coin.name ?: "",
                    coin.symbol ?: "",
                    coin.quote?.usd?.price ?: 0.0,
                    coin.quote?.usd?.volume24h ?: 0.0,
                    coin.quote?.usd?.percentChange1h ?: 0.0,
                    coin.quote?.usd?.percentChange24h ?: 0.0,
                    coin.quote?.usd?.percentChange7d ?: 0.0,
                    coin.quote?.usd?.marketCap ?: 0.0,
                    coin.quote?.usd?.lastUpdated ?: "",
                    false)

}
