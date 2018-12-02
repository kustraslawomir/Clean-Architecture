package slawomir.kustra.domain.intercator.network

import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import slawomir.kustra.domain.executor.PostExecutionThread
import slawomir.kustra.domain.repository.DomainRepository
import slawomir.kustra.domain.test.DataFactory

class GetCryptoListingUserCaseTest {

    private lateinit var getCryptoListingUserCase: GetCryptoListingUserCase
    @Mock
    lateinit var repository: DomainRepository
    @Mock
    lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getCryptoListingUserCase = GetCryptoListingUserCase(repository, postExecutionThread)
    }

    @Test
    fun getCryptoListingCompletes() {
        stubGetCryptoListingUseCase(Observable.just(DataFactory.createCryptoListingResponse(10)))
        val observer = getCryptoListingUserCase.getObservableUseCase().test()
        observer.assertComplete()
    }

    @Test
    fun getCryptoListingReturns() {
        val mockCryptoListingResponse = DataFactory.createCryptoListingResponse(10)
        stubGetCryptoListingUseCase(Observable.just(mockCryptoListingResponse))
        val observer = getCryptoListingUserCase.getObservableUseCase().test()
        observer.assertValue(mockCryptoListingResponse)
    }
    
    private fun stubGetCryptoListingUseCase(observable: Observable<CryptoListingResponse>) {
        whenever(repository.getCoins()).thenReturn(observable)
    }

}