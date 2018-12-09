package slawomir.kustra.remote.service

import io.reactivex.Observable
import slawomir.kustra.data.model.listing.Coin
import slawomir.kustra.data.repositories.RemoteRepository
import slawomir.kustra.remote.mapper.CryptoListingResponseModelMapper
import javax.inject.Inject

class RemoteRepositoryImpl @Inject internal constructor(private val apiService: ApiService,
                                                        private val cryptoListingResponseModelMapper: CryptoListingResponseModelMapper)
    : RemoteRepository {

    override fun getCoinsListing(): Observable<List<Coin>> = apiService.getCryptoListing("f7c959a6-ecc4-4696-8a7c-98edf4156a8a")
            .map {
               cryptoListingResponseModelMapper.mapFromModel(it)
            }

}