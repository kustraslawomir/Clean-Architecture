package slawomir.kustra.domain.repository

import io.reactivex.Observable
import slawomir.kustra.domain.model.listing.Coin
import slawomir.kustra.domain.model.listing.CryptoListingResponse

interface Repository {

    fun getCryptoCurrencyListing(): Observable<CryptoListingResponse>

    fun observeCurrency(id: Int) : io.reactivex.Completable

    fun stopObservingCurrency(id: Int) : io.reactivex.Completable

    fun getObservedCurrencies() : io.reactivex.Observable<List<Coin>>
}