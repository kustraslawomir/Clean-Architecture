package slawomir.kustra.data.repository

import io.reactivex.Completable
import io.reactivex.Observable
import slawomir.kustra.data.entity.listing.CoinEntity

interface DataSource {

    fun getCoins(): Observable<List<CoinEntity>>

    fun saveCoins(coins: List<CoinEntity>): Completable

    fun getObservedCoins():  Observable<List<CoinEntity>>

    fun observeCoin(id: Int): Completable

    fun stopObservingCoin(id: Int): Completable

}