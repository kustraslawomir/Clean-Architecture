package slawomir.kustra.domain.intercator.storage

import io.reactivex.Completable
import slawomir.kustra.domain.executor.PostExecutionThread
import slawomir.kustra.domain.intercator.CompletableUseCase
import slawomir.kustra.domain.repository.DomainRepository

class ObserveCurrencyUseCase(postExecutionThread: PostExecutionThread,
                             private val repository: DomainRepository)
    : CompletableUseCase<ObserveCurrencyUseCase.Params>(postExecutionThread) {

    public override fun getCompletableUseCase(params: Params?): Completable {
        if (params?.id == null) throw IllegalArgumentException("id of currency cannot be null")
        return repository.observeCoin(params.id)
    }

    data class Params constructor(val id: Int) {
        companion object {
            fun forObserveUseCase(id: Int): Params = Params(id)
        }
    }
}