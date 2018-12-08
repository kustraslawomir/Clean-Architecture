package slawomir.kustra.data

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import slawomir.kustra.data.mapper.CoinsListingResponseMapper
import slawomir.kustra.data.repository.CacheRepository
import slawomir.kustra.data.store.DataSourceFactory
import slawomir.kustra.domain.model.listing.Coin
import slawomir.kustra.domain.repository.DomainRepository
import javax.inject.Inject

class DataRepository  @Inject internal constructor(private val coinsListingMapper: CoinsListingResponseMapper,
                                                   private val dataSourceFactory: DataSourceFactory,
                                                   private val cacheRepository: CacheRepository) : DomainRepository {

    override fun getCoins(): Observable<List<Coin>> {

        return Observable.zip(
                cacheRepository.areCoinsCached().toObservable(),
                cacheRepository.isCacheExpired().toObservable(),
                BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>> { cached, expired ->
                    Pair(cached, expired)
                }).flatMap {
            dataSourceFactory.getCoinsList(it.first, it.second).getCoins()
                    .flatMap { coinsList ->
                        dataSourceFactory.getCacheRepository()
                                .saveCoins(coinsList)
                                .andThen(Observable.just(coinsListingMapper.mapFromEntity(coinsList)))
                    }
        }
    }

    override fun observeCoin(id: Int): Completable {
        return dataSourceFactory.getCacheRepository().observeCoin(id)
    }

    override fun stopObservingCoin(id: Int): Completable {
        return dataSourceFactory.getCacheRepository().stopObservingCoin(id)
    }

    override fun getObservedCoins(): Observable<List<Coin>> {
        return dataSourceFactory.getCacheRepository().getObservedCoins()
                .map { coinsListingMapper.mapFromEntity(it) }
    }
}