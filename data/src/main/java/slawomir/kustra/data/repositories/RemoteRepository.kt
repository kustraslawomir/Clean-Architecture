package slawomir.kustra.data.repositories

import io.reactivex.Observable
import slawomir.kustra.data.model.listing.Coin

interface RemoteRepository {

    fun getCoinsListing(): Observable<List<Coin>>

}