package slawomir.kustra.cache.mapper

import slawomir.kustra.cache.model.CacheCoin
import slawomir.kustra.data.entity.listing.CoinEntity

class CachedCoinsMapper : CacheMap<CacheCoin, CoinEntity> {

    override fun mapFromCached(type: CacheCoin): CoinEntity =
            CoinEntity(type.id, type.name, type.symbol, type.price, type.volume24h, type.percentChange1h,
                    type.percentChange24h, type.percentChange7d, type.marketCap, type.lastUpdated, type.isObserved)

    override fun mapToCached(type: CoinEntity): CacheCoin =
            CacheCoin(type.id, type.name, type.symbol, type.price, type.volume24h, type.percentChange1h,
                    type.percentChange24h, type.percentChange7d, type.marketCap, type.lastUpdated, type.isObserved)

}