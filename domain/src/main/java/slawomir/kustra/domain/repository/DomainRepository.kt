package slawomir.kustra.domain.repository

import io.reactivex.Observable
import slawomir.kustra.domain.model.listing.Coin

interface DomainRepository {

    fun getCoins(): Observable<List<Coin>>

    fun observeCoin(id: Int) : io.reactivex.Completable

    fun stopObservingCoin(id: Int) : io.reactivex.Completable

    fun getObservedCoins() : io.reactivex.Observable<List<Coin>>
}