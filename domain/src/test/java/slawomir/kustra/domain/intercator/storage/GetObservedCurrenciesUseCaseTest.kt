package slawomir.kustra.domain.intercator.storage

import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import slawomir.kustra.domain.executor.PostExecutionThread
import slawomir.kustra.domain.model.listing.Coin
import slawomir.kustra.domain.repository.DomainRepository
import slawomir.kustra.domain.test.DataFactory


class GetObservedCurrenciesUseCaseTest {

    private lateinit var getObservedCurrenciesUseCase: GetObservedCoinsUseCase
    @Mock
    private lateinit var repository: DomainRepository
    @Mock
    private lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getObservedCurrenciesUseCase = GetObservedCoinsUseCase(repository, postExecutionThread)
    }

    @Test
    fun getObservedCoinsListCompleted() {
        stubCoinsList(Observable.just(DataFactory.createCoinsList(10)))
        val observable = getObservedCurrenciesUseCase.getObservableUseCase().test()
        observable.assertComplete()
    }

    @Test
    fun getObservedCoinsListReturned() {
        val coinsList = DataFactory.createCoinsList(10)
        stubCoinsList(Observable.just(coinsList))
        val observable = getObservedCurrenciesUseCase.getObservableUseCase().test()
        observable.assertValue(coinsList)
    }

    private fun stubCoinsList(observable: Observable<List<Coin>>) {
        whenever(repository.getObservedCoins()).thenReturn(observable)
    }
}