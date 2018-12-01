package slawomir.kustra.domain.repository

import io.reactivex.Single
import slawomir.kustra.domain.model.listing.Coin
import slawomir.kustra.domain.model.listing.CryptoListingResponse

interface Repository {

    fun getCryptoCurrencyListing(): Single<CryptoListingResponse>

    fun pinCoin(id: Int) : io.reactivex.Completable

    fun unPinCoin(id: Int) : io.reactivex.Completable

    fun getPinnedCoins() : io.reactivex.Observable<Coin>
}