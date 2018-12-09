package slawomir.kustra.data.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import slawomir.kustra.data.model.listing.Coin

interface CacheRepository {

    fun clearCoinsCache(): Completable

    fun saveCoinsInCash(coins: List<Coin>): Completable

    fun getCoins(): Observable<List<Coin>>

    fun getObservedCoins(): Observable<List<Coin>>

    fun observeCoin(id: Int): Completable

    fun stopObservingCoin(id: Int): Completable

    fun areCoinsCached() : Boolean

    fun setLastCacheTime(timestamp: Long) : Completable

    fun isCacheExpired() : Boolean
}