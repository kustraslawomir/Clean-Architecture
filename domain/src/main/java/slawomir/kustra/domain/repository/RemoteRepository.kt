package slawomir.kustra.domain.repository

import io.reactivex.Single
import slawomir.kustra.domain.model.listing.CryptoListingResponse

interface RemoteRepository {

    fun getListing(): Single<CryptoListingResponse>

}