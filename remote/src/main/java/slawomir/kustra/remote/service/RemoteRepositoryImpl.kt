package slawomir.kustra.remote.service

import io.reactivex.Observable
import slawomir.kustra.data.entity.listing.CoinEntity
import slawomir.kustra.data.repository.RemoteRepository
import slawomir.kustra.remote.mapper.CryptoListingResponseModelMapper

class RemoteRepositoryImpl(private val apiService: ApiService,
                           private val cryptoListingResponseModelMapper: CryptoListingResponseModelMapper)
    : RemoteRepository {

    override fun getCoinsListing(): Observable<List<CoinEntity>> = apiService.getCryptoListing("f7c959a6-ecc4-4696-8a7c-98edf4156a8a")
            .map {
               cryptoListingResponseModelMapper.mapFromModel(it)
            }

}