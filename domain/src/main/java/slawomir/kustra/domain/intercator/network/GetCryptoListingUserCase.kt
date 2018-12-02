package slawomir.kustra.domain.intercator.network

import io.reactivex.Observable
import slawomir.kustra.domain.executor.PostExecutionThread
import slawomir.kustra.domain.intercator.ObservableUseCase
import slawomir.kustra.domain.model.listing.Coin
import slawomir.kustra.domain.repository.DomainRepository

class GetCryptoListingUserCase constructor(private val repository: DomainRepository,
                                           postExecutionThread: PostExecutionThread)
    : ObservableUseCase<List<Coin>, Nothing?>(postExecutionThread) {

    public override fun getObservableUseCase(params: Nothing?): Observable<List<Coin>> =
            repository.getCoins()
}