package slawomir.kustra.cache

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.rxkotlin.toSingle
import slawomir.kustra.cache.Constants.CACHE_EXPIRATION_VALUE
import slawomir.kustra.cache.database.CacheDatabase
import slawomir.kustra.cache.mapper.CachedCoinsMapper
import slawomir.kustra.cache.model.CacheConfig
import slawomir.kustra.data.model.listing.Coin
import slawomir.kustra.data.repositories.CacheRepository
import javax.inject.Inject

open class CacheRepositoryImpl @Inject internal constructor(private val cachedCoinsMapper: CachedCoinsMapper,
                                                            private val cacheDatabase: CacheDatabase) : CacheRepository {

    override fun clearCoinsCache(): Completable = Completable.defer {
        cacheDatabase.coinsDao().clearCache()
        Completable.complete()
    }

    override fun saveCoinsInCash(coins: List<Coin>): Completable = Completable.defer {
        cacheDatabase.coinsDao().insertCoins(
                coins.map {
                    cachedCoinsMapper.mapToCached(it)
                })
        Completable.complete()
    }

    override fun getCoins(): Observable<List<Coin>> = cacheDatabase
            .coinsDao().getCachedCoins()
            .toObservable()
            .map { it ->
                it.map {
                    cachedCoinsMapper.mapFromCached(it)
                }
            }

    override fun getObservedCoins(): Observable<List<Coin>> =
            cacheDatabase.coinsDao().getObservedCoins()
                    .toObservable()
                    .map { it ->
                        it.map { cachedCoinsMapper.mapFromCached(it) }
                    }

    override fun observeCoin(id: Int): Completable {
        cacheDatabase.coinsDao().changeObserveCoinState(true, id)
        return Completable.complete()
    }

    override fun stopObservingCoin(id: Int): Completable {
        cacheDatabase.coinsDao().changeObserveCoinState(false, id)
        return Completable.complete()
    }

    override fun areCoinsCached(): Single<Boolean> = cacheDatabase.coinsDao().getCachedCoins().isEmpty
            .map {
                !it
            }

    override fun setLastCacheTime(timestamp: Long): Completable {
        cacheDatabase.cacheConfigDao().insertCacheConfig(CacheConfig(timestamp))
        return Completable.complete()
    }

    override fun isCacheExpired(): Single<Boolean> {
        val currentTime = System.currentTimeMillis()
        val cacheTime = cacheDatabase.cacheConfigDao().getCacheTime()
        return (currentTime - cacheTime.lastCacheTime > CACHE_EXPIRATION_VALUE).toSingle()
    }
}