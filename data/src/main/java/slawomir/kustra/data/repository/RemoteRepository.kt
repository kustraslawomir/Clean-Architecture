package slawomir.kustra.data.repository

import io.reactivex.Observable

interface RemoteRepository {

    fun getCoinsListing(): Observable<CryptoListingEntity>

}