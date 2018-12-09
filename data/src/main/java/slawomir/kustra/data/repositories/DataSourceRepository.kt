package slawomir.kustra.data.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import slawomir.kustra.data.model.listing.Coin

interface DataSourceRepository {

    fun getCoins(): Observable<List<Coin>>

    fun saveCoins(coins: List<Coin>): Completable

    fun getObservedCoins():  Observable<List<Coin>>

    fun observeCoin(id: Int): Completable

    fun stopObservingCoin(id: Int): Completable

}