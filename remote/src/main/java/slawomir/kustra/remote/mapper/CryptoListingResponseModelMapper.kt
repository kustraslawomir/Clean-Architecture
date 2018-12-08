package slawomir.kustra.remote.mapper

import slawomir.kustra.data.entity.listing.CoinEntity
import slawomir.kustra.remote.model.CryptoListingsResponse
import javax.inject.Inject

class CryptoListingResponseModelMapper @Inject internal constructor(): ModelMapper<CryptoListingsResponse, List<CoinEntity>> {

    override fun mapFromModel(model: CryptoListingsResponse): List<CoinEntity> = mapData(model)

    private fun mapData(model: CryptoListingsResponse?): List<CoinEntity> {
        val coinsEntities = mutableListOf<CoinEntity>()

        if (model != null && model.data?.isNotEmpty() == true) {
            model.data?.forEach { coin -> coinsEntities.add(mapCoin(coin)) }
        }
        return coinsEntities
    }

    private fun mapCoin(coin: slawomir.kustra.remote.model.Coin) = CoinEntity(coin.id,
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
