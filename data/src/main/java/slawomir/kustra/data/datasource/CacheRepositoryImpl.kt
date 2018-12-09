package slawomir.kustra.data.datasource

import io.reactivex.Completable
import io.reactivex.Observable
import slawomir.kustra.data.model.listing.Coin
import slawomir.kustra.data.repositories.CacheRepository
import slawomir.kustra.data.repositories.DataSourceRepository
import javax.inject.Inject

class CacheRepositoryImpl @Inject internal constructor(private val cacheRepository: CacheRepository) : DataSourceRepository {

    override fun getCoins(): Observable<List<Coin>> = cacheRepository.getCoins()

    override fun saveCoins(coins: List<Coin>): Completable {
        val cacheList = cacheRepository.getCoins()
        if (cacheList != coins) {
            cacheRepository.saveCoinsInCash(coins)
            cacheRepository.setLastCacheTime(System.currentTimeMillis())
        }
        return Completable.complete()
    }

    override fun getObservedCoins(): Observable<List<Coin>> = cacheRepository.getObservedCoins()

    override fun observeCoin(id: Int): Completable = cacheRepository.observeCoin(id)

    override fun stopObservingCoin(id: Int): Completable = cacheRepository.stopObservingCoin(id)
}