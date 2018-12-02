package slawomir.kustra.domain.intercator.storage

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Completable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import slawomir.kustra.domain.executor.PostExecutionThread
import slawomir.kustra.domain.repository.DomainRepository
import slawomir.kustra.domain.test.DataFactory

class ObserveCurrencyUseCaseTest {

    private lateinit var observeCurrencyUseCase: ObserveCurrencyUseCase
    @Mock
    lateinit var repository: DomainRepository
    @Mock
    lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        observeCurrencyUseCase = ObserveCurrencyUseCase(postExecutionThread, repository)
    }

    @Test
    fun observeCurrencyUseCaseCompletes() {
        stubObserveCurrencyUseCase(Completable.complete())
        val observable = observeCurrencyUseCase.getCompletableUseCase(
                ObserveCurrencyUseCase.Params.forObserveUseCase(DataFactory.randomInt()))
                .test()
        observable.assertComplete()
    }

    @Test(expected = IllegalArgumentException::class)
    fun observeThrowsException() {
        observeCurrencyUseCase.getCompletableUseCase()
                .test()
    }

    private fun stubObserveCurrencyUseCase(completable: Completable) {
        whenever(repository.observeCoin(any()))
                .thenReturn(completable)
    }
}