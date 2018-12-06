package slawomir.kustra.data.mapper

import slawomir.kustra.data.entity.listing.CoinEntity
import slawomir.kustra.domain.model.listing.Coin

class CoinsListingResponseMapper : EntityMapper<List<CoinEntity>, List<Coin>> {

    override fun mapFromEntity(entity: List<CoinEntity>): List<Coin> {
        return mapData(entity)
    }

    private fun mapData(data: List<CoinEntity>?): List<Coin> {
        val coinsEntities = mutableListOf<Coin>()

        if (data != null && !data.isEmpty()) {
            data.forEach { coin -> coinsEntities.add(mapCoin(coin)) }
        }
        return coinsEntities
    }

    private fun mapCoin(coin: CoinEntity) = Coin(coin.id,
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