package slawomir.kustra.data.datasource

import io.reactivex.Completable
import io.reactivex.Observable
import slawomir.kustra.data.model.listing.Coin
import slawomir.kustra.data.repositories.DataSourceRepository
import slawomir.kustra.data.repositories.RemoteRepository
import javax.inject.Inject

class RemoteRepositoryImpl @Inject internal constructor(private val remoteRepository: RemoteRepository) : DataSourceRepository {

    override fun getCoins(): Observable<List<Coin>> {
        return remoteRepository.getCoinsListing()
    }

    override fun saveCoins(coins: List<Coin>): Completable {
        throw java.lang.UnsupportedOperationException("saveCoins is not supported by RemoteRepositoryImpl class")
    }

    override fun getObservedCoins(): Observable<List<Coin>> {
        throw java.lang.UnsupportedOperationException("getObservedCoins is not supported by RemoteRepositoryImpl class")
    }

    override fun observeCoin(id: Int): Completable {
        throw java.lang.UnsupportedOperationException("observeCoin is not supported by RemoteRepositoryImpl class")
    }

    override fun stopObservingCoin(id: Int): Completable {
        throw UnsupportedOperationException("stopObservingCoin is not supported by RemoteRepositoryImpl class")
    }

}