package slawomir.kustra.cache.mapper

import slawomir.kustra.cache.model.CacheCoin
import slawomir.kustra.data.model.listing.Coin
import javax.inject.Inject

class CachedCoinsMapper  @Inject internal constructor() : CacheMap<CacheCoin, Coin> {

    override fun mapFromCached(type: CacheCoin): Coin =
            Coin(type.id, type.name, type.symbol, type.price, type.volume24h, type.percentChange1h,
                    type.percentChange24h, type.percentChange7d, type.marketCap, type.lastUpdated, type.isObserved)

    override fun mapToCached(type: Coin): CacheCoin =
            CacheCoin(type.id, type.name, type.symbol, type.price, type.volume24h, type.percentChange1h,
                    type.percentChange24h, type.percentChange7d, type.marketCap, type.lastUpdated, type.isObserved)

}