package slawomir.kustra.data

import io.reactivex.Completable
import io.reactivex.Observable
import slawomir.kustra.data.datasource.DataSourceFactory
import slawomir.kustra.data.model.listing.Coin
import slawomir.kustra.data.repositories.CacheRepository
import javax.inject.Inject

class ApplicationDataSourceImpl @Inject constructor(private val dataSourceFactory: DataSourceFactory,
                                                    private val cacheRepository: CacheRepository) : ApplicationDataSource {

    override fun getCoins(): Observable<List<Coin>> =
            dataSourceFactory.getCoinsList(cacheRepository.areCoinsCached(), cacheRepository.isCacheExpired())
                    .getCoins()
                    .flatMap { coinsList ->
                        dataSourceFactory
                                .getCacheRepository()
                                .saveCoins(coinsList)
                                .andThen(Observable.just(coinsList))
                    }


    override fun observeCoin(id: Int): Completable {
        return dataSourceFactory.getCacheRepository().observeCoin(id)
    }


    override fun stopObservingCoin(id: Int): Completable {
        return dataSourceFactory.getCacheRepository().stopObservingCoin(id)
    }

    override fun getObservedCoins(): Observable<List<Coin>> {
        return dataSourceFactory.getCacheRepository().getObservedCoins()
    }

}