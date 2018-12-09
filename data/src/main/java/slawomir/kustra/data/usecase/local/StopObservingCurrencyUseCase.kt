package slawomir.kustra.data.usecase.local

import io.reactivex.Completable
import slawomir.kustra.data.ApplicationDataSource
import slawomir.kustra.data.executor.PostExecutionThread
import slawomir.kustra.data.usecase.CompletableUseCase
import javax.inject.Inject

class StopObservingCurrencyUseCase @Inject internal constructor(postExecutionThread: PostExecutionThread,
                                                                private val  repository: ApplicationDataSource)
    : CompletableUseCase<StopObservingCurrencyUseCase.Params>(postExecutionThread) {

    public override fun getCompletableUseCase(params: StopObservingCurrencyUseCase.Params?): Completable {
        if (params==null) throw IllegalArgumentException("id of currency cannot be null")
        return repository.stopObservingCoin(params.id)
    }

    data class Params constructor(val id: Int){
        companion object {
            fun forStopObservingCurrency(id: Int) : Params = Params(id)
        }
    }
}