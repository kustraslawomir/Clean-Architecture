package slawomir.kustra.data.store

import io.reactivex.Completable
import io.reactivex.Observable
import slawomir.kustra.data.entity.listing.CoinEntity
import slawomir.kustra.data.repository.DataSource
import slawomir.kustra.data.repository.RemoteRepository

class RemoteRepositoryImpl(private val remoteRepository: RemoteRepository) : DataSource {
    
    override fun getCoins(): Observable<List<CoinEntity>> {
        return remoteRepository.getCoinsListing().map {
            it.data
        }
    }

    override fun saveCoins(coins: List<CoinEntity>): Completable {
        throw java.lang.UnsupportedOperationException("saveCoins is not supported RemoteRepositoryImpl class")
    }

    override fun getObservedCoins(): Observable<List<CoinEntity>> {
        throw java.lang.UnsupportedOperationException("getObservedCoins is not supported RemoteRepositoryImpl class")
    }

    override fun observeCoin(id: Int): Completable {
        throw java.lang.UnsupportedOperationException("observeCoin is not supported RemoteRepositoryImpl class")
    }

    override fun stopObservingCoin(id: Int): Completable {
        throw UnsupportedOperationException("stopObservingCoin is not supported RemoteRepositoryImpl class")
    }

}