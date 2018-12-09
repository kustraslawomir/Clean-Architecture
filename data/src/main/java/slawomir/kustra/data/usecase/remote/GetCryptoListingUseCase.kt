package slawomir.kustra.data.usecase.remote

import io.reactivex.Observable
import slawomir.kustra.data.ApplicationDataSource
import slawomir.kustra.data.executor.PostExecutionThread
import slawomir.kustra.data.model.listing.Coin
import slawomir.kustra.data.usecase.ObservableUseCase
import javax.inject.Inject

class GetCryptoListingUseCase @Inject internal constructor(private val repository: ApplicationDataSource,
                                                           postExecutionThread: PostExecutionThread)
    : ObservableUseCase<List<Coin>, Nothing?>(postExecutionThread) {

    public override fun getObservableUseCase(params: Nothing?): Observable<List<Coin>> =
            repository.getCoins()
}