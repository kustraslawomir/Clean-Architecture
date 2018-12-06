package slawomir.kustra.data.repository

import io.reactivex.Observable
import slawomir.kustra.data.entity.listing.CoinEntity

interface RemoteRepository {

    fun getCoinsListing(): Observable<List<CoinEntity>>

}