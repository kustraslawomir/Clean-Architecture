package slawomir.kustra.domain.intercator.storage

import io.reactivex.Completable
import slawomir.kustra.domain.executor.PostExecutionThread
import slawomir.kustra.domain.intercator.CompletableUseCase
import slawomir.kustra.domain.repository.DomainRepository

class StopObservingCurrencyUseCase(postExecutionThread: PostExecutionThread,
                                   private val  repository: DomainRepository)
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