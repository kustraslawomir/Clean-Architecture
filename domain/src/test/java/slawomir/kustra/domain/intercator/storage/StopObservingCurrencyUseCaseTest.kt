package slawomir.kustra.domain.intercator.storage

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Completable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import slawomir.kustra.domain.executor.PostExecutionThread
import slawomir.kustra.domain.repository.Repository
import slawomir.kustra.domain.test.DataFactory

class StopObservingCurrencyUseCaseTest {

    private lateinit var stopObservingCurrencyUseCase: StopObservingCurrencyUseCase
    @Mock
    lateinit var repository: Repository
    @Mock
    lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        stopObservingCurrencyUseCase = StopObservingCurrencyUseCase(postExecutionThread, repository)
    }

    @Test
    fun stopObservingCurrencyUseCaseCompletes() {
        stubStopObservingCurrencyUseCase(Completable.complete())
        val observable = stopObservingCurrencyUseCase.getCompletableUseCase(
                StopObservingCurrencyUseCase.Params.forStopObservingCurrency(DataFactory.randomInt()))
                .test()
        observable.assertComplete()
    }

    @Test(expected = IllegalArgumentException::class)
    fun stopObservingThrowsException() {
        stopObservingCurrencyUseCase.getCompletableUseCase()
                .test()
    }

    private fun stubStopObservingCurrencyUseCase(completable: Completable) {
        whenever(repository.stopObservingCurrency(any()))
                .thenReturn(completable)
    }
}