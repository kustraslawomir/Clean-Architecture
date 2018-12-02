package slawomir.kustra.data.repository

import io.reactivex.Observable
import slawomir.kustra.data.entity.listing.CryptoListingEntity

interface RemoteRepository {

    fun getCoinsListing(): Observable<CryptoListingEntity>

}