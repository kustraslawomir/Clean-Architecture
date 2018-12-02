package slawomir.kustra.data.repository

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import slawomir.kustra.data.entity.listing.CoinEntity

interface CacheRepository {

    fun clearCash(): Completable

    fun saveCoinsInCash(coins: List<CoinEntity>): Completable

    fun getCoins(): Observable<List<CoinEntity>>

    fun getObservedCoins(): Observable<List<CoinEntity>>

    fun observeCoin(id: Int): Completable

    fun stopObservingCoin(id: Int): Completable

    fun areCoinsCached() : Single<Boolean>

    fun setCachceTime(timestamp: Long) : Completable

    fun isCacheExpired() : Single<Boolean>
}