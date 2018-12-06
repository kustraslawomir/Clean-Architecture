package slawomir.kustra.remote.mapper

import slawomir.kustra.data.entity.listing.CoinEntity
import slawomir.kustra.remote.model.CryptoListingsResponse

class CryptoListingResponseModelMapper : ModelMapper<CryptoListingsResponse, List<CoinEntity>> {


    override fun mapFromModel(model: CryptoListingsResponse): List<CoinEntity> = mapData(model)


    private fun mapData(model: CryptoListingsResponse?): List<CoinEntity> {
        val coinsEntities = mutableListOf<CoinEntity>()

        if (model != null && model.data?.isNotEmpty() == true) {
            model.data?.forEach { coin -> coinsEntities.add(mapCoin(coin)) }
        }
        return coinsEntities
    }

    private fun mapCoin(coin: slawomir.kustra.remote.model.Coin) = CoinEntity(coin.id,
            coin.name,
            coin.symbol,
            coin.quote?.usd?.price,
            coin.quote?.usd?.volume24h,
            coin.quote?.usd?.percentChange1h,
            coin.quote?.usd?.percentChange24h,
            coin.quote?.usd?.percentChange7d,
            coin.quote?.usd?.marketCap,
            coin.quote?.usd?.lastUpdated)

}
