package slawomir.kustra.data

import io.reactivex.Observable
import slawomir.kustra.data.model.listing.Coin

interface ApplicationDataSource {

    fun getCoins(): Observable<List<Coin>>

    fun observeCoin(id: Int) : io.reactivex.Completable

    fun stopObservingCoin(id: Int) : io.reactivex.Completable

    fun getObservedCoins() : io.reactivex.Observable<List<Coin>>
}