package slawomir.kustra.data.usecase.local

import io.reactivex.Completable
import slawomir.kustra.data.ApplicationDataSource
import slawomir.kustra.data.executor.PostExecutionThread
import slawomir.kustra.data.usecase.CompletableUseCase
import javax.inject.Inject

class ObserveCurrencyUseCase @Inject internal constructor(postExecutionThread: PostExecutionThread,
                             private val repository: ApplicationDataSource)
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