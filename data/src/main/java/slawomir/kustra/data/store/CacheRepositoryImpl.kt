package slawomir.kustra.data.store

import io.reactivex.Completable
import io.reactivex.Observable
import slawomir.kustra.data.entity.listing.CoinEntity
import slawomir.kustra.data.repository.CacheRepository
import slawomir.kustra.data.repository.DataSourceRepository

class CacheRepositoryImpl(private val cacheRepository: CacheRepository) : DataSourceRepository {

    override fun getCoins(): Observable<List<CoinEntity>> = cacheRepository.getCoins()

    override fun saveCoins(coins: List<CoinEntity>): Completable = cacheRepository.saveCoinsInCash(coins)
            .andThen(cacheRepository.setLastCacheTime(System.currentTimeMillis()))

    override fun getObservedCoins(): Observable<List<CoinEntity>> = cacheRepository.getObservedCoins()

    override fun observeCoin(id: Int): Completable = cacheRepository.observeCoin(id)

    override fun stopObservingCoin(id: Int): Completable = cacheRepository.stopObservingCoin(id)
}