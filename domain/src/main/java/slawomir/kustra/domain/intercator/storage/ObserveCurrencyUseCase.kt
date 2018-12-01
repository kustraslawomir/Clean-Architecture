package slawomir.kustra.domain.intercator.storage

import io.reactivex.Completable
import slawomir.kustra.domain.executor.PostExecutionThread
import slawomir.kustra.domain.intercator.CompletableUseCase
import slawomir.kustra.domain.repository.Repository

class ObserveCurrencyUseCase(postExecutionThread: PostExecutionThread,
                             private val repository: Repository)
    : CompletableUseCase<ObserveCurrencyUseCase.Params>(postExecutionThread) {

    override fun getCompletableUseCase(params: Params?): Completable {
        if (params?.id == null) throw IllegalArgumentException("id of currency cannot be null")
        return repository.observeCurrency(params.id)
    }

    data class Params constructor(val id: Int) {
        companion object {
            fun forObserveUseCase(id: Int): Params = Params(id)
        }
    }
}