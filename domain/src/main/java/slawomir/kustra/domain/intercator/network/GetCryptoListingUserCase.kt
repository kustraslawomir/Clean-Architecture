package slawomir.kustra.domain.intercator.network

import io.reactivex.Observable
import slawomir.kustra.domain.executor.PostExecutionThread
import slawomir.kustra.domain.intercator.ObservableUseCase
import slawomir.kustra.domain.model.listing.CryptoListingResponse
import slawomir.kustra.domain.repository.Repository

class GetCryptoListingUserCase constructor(private val repository: Repository,
                                           postExecutionThread: PostExecutionThread)
    : ObservableUseCase<CryptoListingResponse, Nothing?>(postExecutionThread) {

    override fun getObservableUseCase(params: Nothing?): Observable<CryptoListingResponse> =
            repository.getCryptoCurrencyListing()
}